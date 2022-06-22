package com.example.SOLIDBankApp4.service.controller;

import com.example.SOLIDBankApp4.entity.transaction.Transaction;
import com.example.SOLIDBankApp4.service.TransactionListingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class TransactionController {
    TransactionListingService transactionListingService;

    @GetMapping("/transactions")
    public List<Transaction> getClientTransactions(@RequestParam String clientID){
        return transactionListingService.getClientTransactions(clientID);
    }

    @GetMapping("/{accountID}/transactions")
    public List<Transaction> getClientTransactionsByAccountID(@RequestParam String clientID, @PathVariable String accountID) {
        return transactionListingService.getClientTransactionsByAccountID(clientID, accountID);
    }
}
