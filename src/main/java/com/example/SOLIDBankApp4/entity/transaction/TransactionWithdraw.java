package com.example.SOLIDBankApp4.entity.transaction;

import com.example.SOLIDBankApp4.dao.TransactionDAO;
import com.example.SOLIDBankApp4.service.AccountWithdrawService;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO){
        this.accountWithdrawService=accountWithdrawService;
        this.transactionDAO=transactionDAO;
    }
    public void execute(String accountID, double amount){
        accountWithdrawService.withdraw(amount, accountID);
    }
}