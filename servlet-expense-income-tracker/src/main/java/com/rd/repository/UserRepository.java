
package com.rd.repository;

import com.rd.model.User;
import java.sql.*;
import java.util.*;

public class UserRepository {
    private Connection conn;

    public UserRepository(Connection conn) {
        this.conn = conn;
    }

    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
        }
        return null;
    }

    public boolean createUser(String username, String password) throws SQLException {
        String query = "INSERT INTO users(username, password) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        return ps.executeUpdate() > 0;
    }

    // Add update and delete if needed
}
