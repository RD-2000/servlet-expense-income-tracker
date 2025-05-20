

package com.rd.service;

import com.rd.model.Wallet;
import com.rd.repository.WalletRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WalletService {
    private WalletRepository repo;

    public WalletService(Connection conn) {
        this.repo = new WalletRepository(conn);
    }

    public boolean createWallet(String name, double balance, int userId) throws SQLException {
        return repo.createWallet(name, balance, userId);
    }

    public List<Wallet> getAllWallets(int userId) throws SQLException {
        return repo.getAllWallets(userId);
    }

    public boolean updateWallet(int id, String name, double balance) throws SQLException {
        return repo.updateWallet(id, name, balance);
    }

    public boolean deleteWallet(int id) throws SQLException {
        return repo.deleteWallet(id);
    }
}
