package com.example.SOLIDBankApp4.entity.transaction;

import com.example.SOLIDBankApp4.dao.TransactionDAO;
import com.example.SOLIDBankApp4.service.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO){
        this.accountDepositService=accountDepositService;
        this.transactionDAO=transactionDAO;
    }
    public void execute(String accountID, double amount){
        accountDepositService.deposit(amount, accountID);
    }
}