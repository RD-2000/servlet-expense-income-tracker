package com.rd.service;

import com.rd.model.Transaction;
import com.rd.repository.TransactionRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    private TransactionRepository repo;

    public TransactionService(Connection conn) {
        this.repo = new TransactionRepository(conn);
    }

    public boolean createTransaction(int walletId, String type, double amount) throws SQLException {
        return repo.createTransaction(walletId, type, amount);
    }

    public List<Transaction> getTransactionsByWalletId(int walletId) throws SQLException {
        return repo.getTransactionsByWalletId(walletId);
    }

    public boolean updateTransaction(int id, String type, double amount) throws SQLException {
        return repo.updateTransaction(id, type, amount);
    }

    public boolean deleteTransaction(int id) throws SQLException {
        return repo.deleteTransaction(id);
    }
}

