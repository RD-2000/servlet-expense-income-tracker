package com.rd.repository;
import com.rd.model.Wallet;

import java.sql.*;
import java.util.*;

public class WalletRepository {
    private Connection conn;

    public WalletRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean createWallet(String name, double balance, int userId) throws SQLException {
        String query = "INSERT INTO wallets(name, balance, user_id) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setDouble(2, balance);
        ps.setInt(3, userId);
        return ps.executeUpdate() > 0;
    }
    public List<Wallet> getAllWallets(int userId) throws SQLException {
        List<Wallet> wallets = new ArrayList<>();
        String query = "SELECT * FROM wallets WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            wallets.add(new Wallet(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getDouble("balance")
            ));
        }
        return wallets;
    }
    public boolean updateWallet(int id, String name, double balance) throws SQLException {
        String query = "UPDATE wallets SET name=?, balance=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setDouble(2, balance);
        ps.setInt(3, id);
        return ps.executeUpdate() > 0;
    }

    public boolean deleteWallet(int id) throws SQLException {
        String query = "DELETE FROM wallets WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
}


