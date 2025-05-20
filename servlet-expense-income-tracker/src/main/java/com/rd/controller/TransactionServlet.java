package com.rd.controller;

import com.rd.databaseconnection.DatabaseConnection;
import com.rd.model.Transaction;
import com.rd.service.TransactionService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransactionService service = new TransactionService(conn);
            int walletId = Integer.parseInt(req.getParameter("walletId"));
            List<Transaction> transactions = service.getTransactionsByWalletId(walletId);

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.write("[");
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                out.write(String.format("{\"id\":%d,\"walletId\":%d,\"type\":\"%s\",\"amount\":%.2f,\"timestamp\":\"%s\"}%s",
                        t.getId(), t.getWalletId(), t.getType(), t.getAmount(), t.getTimestamp().toString(), (i < transactions.size() - 1) ? "," : ""));
            }
            out.write("]");
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransactionService service = new TransactionService(conn);
            int walletId = Integer.parseInt(req.getParameter("walletId"));
            String type = req.getParameter("type");
            double amount = Double.parseDouble(req.getParameter("amount"));
            boolean created = service.createTransaction(walletId, type, amount);
            resp.setStatus(created ? 201 : 400);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransactionService service = new TransactionService(conn);
            int id = Integer.parseInt(req.getParameter("id"));
            String type = req.getParameter("type");
            double amount = Double.parseDouble(req.getParameter("amount"));
            boolean updated = service.updateTransaction(id, type, amount);
            resp.setStatus(updated ? 200 : 404);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            TransactionService service = new TransactionService(conn);
            int id = Integer.parseInt(req.getParameter("id"));
            boolean deleted = service.deleteTransaction(id);
            resp.setStatus(deleted ? 200 : 404);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
}
