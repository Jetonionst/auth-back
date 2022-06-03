package com.example.SOLIDBankApp4.dao.internal;

import com.example.SOLIDBankApp4.dao.TransactionDAO;
import com.example.SOLIDBankApp4.entity.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    List<Transaction> transactions;

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}