package com.rd.service;

import com.rd.model.User;
import com.rd.repository.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserRepository repo;

    public UserService(Connection conn) {
        this.repo = new UserRepository(conn);
    }

    public User getUserById(int id) throws SQLException {
        return repo.getUserById(id);
    }

    public boolean createUser(String username, String password) throws SQLException {
        return repo.createUser(username, password);
    }
}

