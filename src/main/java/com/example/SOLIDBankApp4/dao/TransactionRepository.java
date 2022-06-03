package com.example.SOLIDBankApp4.dao;

import com.example.SOLIDBankApp4.entity.transaction.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    @Query("SELECT * FROM Transaction WHERE client_id = :clientID")
    List<Transaction> getClientTransactions(String clientID);

    @Query("SELECT * FROM Transaction WHERE client_id = :clientID AND account_id = :accountID")
    List<Transaction> getClientTransactionsByAccountID(String clientID, String accountID);

    @Modifying
    @Query("INSERT INTO Transaction(transaction_type, client_id, account_id, amount, bank_id) " +
            "VALUES(:transactionType, :clientID, :accountID, :amount, :bankID)")
    void createNewTransaction(String transactionType, String clientID, String accountID, double amount, long bankID);
}