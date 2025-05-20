package com.rd.controller;

import com.rd.databaseconnection.DatabaseConnection;
import com.rd.model.Wallet;
import com.rd.service.WalletService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.*;

public class WalletServlet extends HttpServlet {

    protected <HttpServletRequest> void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            WalletService service = new WalletService(conn);
            List<Wallet> wallets = service.getAllWallets(1);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            out.write("[");
            for (int i = 0; i < wallets.size(); i++) {
                Wallet w = wallets.get(i);
                out.write(String.format("{\"id\":%d,\"name\":\"%s\",\"balance\":%.2f}%s",
                        w.getId(), w.getName(), w.getBalance(), (i < wallets.size() - 1) ? "," : ""));
            }
            out.write("]");
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            WalletService service = new WalletService(conn);
            String name = req.getParameter("name");
            double balance = Double.parseDouble(req.getParameter("balance"));
            service.createWallet(name, balance, 1);
            resp.setStatus(201);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            WalletService service = new WalletService(conn);
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double balance = Double.parseDouble(req.getParameter("balance"));
            boolean updated = service.updateWallet(id, name, balance);
            resp.setStatus(updated ? 200 : 404);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            WalletService service = new WalletService(conn);
            int id = Integer.parseInt(req.getParameter("id"));
            boolean deleted = service.deleteWallet(id);
            resp.setStatus(deleted ? 200 : 404);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
}






