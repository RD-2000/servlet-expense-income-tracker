package com.rd.repository;

import com.rd.model.Transaction;
import java.sql.*;
import java.util.*;

public class TransactionRepository {
    private Connection conn;

    public TransactionRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean createTransaction(int walletId, String type, double amount) throws SQLException {
        String query = "INSERT INTO transactions(wallet_id, type, amount) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, walletId);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        return ps.executeUpdate() > 0;
    }

    public List<Transaction> getTransactionsByWalletId(int walletId) throws SQLException {
        List<Transaction> list = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE wallet_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, walletId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Transaction(
                    rs.getInt("id"),
                    rs.getInt("wallet_id"),
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    rs.getTimestamp("timestamp")
            ));
        }
        return list;
    }

    public boolean updateTransaction(int id, String type, double amount) throws SQLException {
        String query = "UPDATE transactions SET type=?, amount=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, type);
        ps.setDouble(2, amount);
        ps.setInt(3, id);
        return ps.executeUpdate() > 0;
    }

    public boolean deleteTransaction(int id) throws SQLException {
        String query = "DELETE FROM transactions WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
}
