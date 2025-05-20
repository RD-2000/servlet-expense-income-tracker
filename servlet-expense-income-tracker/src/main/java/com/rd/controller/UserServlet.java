package com.rd.controller;

import com.rd.databaseconnection.DatabaseConnection;
import com.rd.model.User;
import com.rd.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            UserService service = new UserService(conn);
            int userId = Integer.parseInt(req.getParameter("id"));
            User user = service.getUserById(userId);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            if (user != null) {
                out.write(String.format("{\"id\":%d,\"username\":\"%s\"}", user.getId(), user.getUsername()));
            } else {
                resp.setStatus(404);
            }
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            UserService service = new UserService(conn);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean created = service.createUser(username, password);
            resp.setStatus(created ? 201 : 400);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
}

