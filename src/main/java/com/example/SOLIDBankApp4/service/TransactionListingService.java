package com.example.SOLIDBankApp4.service;

import com.example.SOLIDBankApp4.entity.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionListingService {
    List<Transaction> getClientTransactions(String clientID);
    List<Transaction> getClientTransactionsByAccountID(String clientID, String accountID);
}
