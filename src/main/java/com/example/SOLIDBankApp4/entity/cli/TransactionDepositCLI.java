package com.example.SOLIDBankApp4.entity.cli;

import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.transaction.TransactionDeposit;
import com.example.SOLIDBankApp4.entity.ui.WithdrawDepositOperationCLIUI;
import com.example.SOLIDBankApp4.service.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI{
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionDeposit=transactionDeposit;
        this.withdrawDepositOperationCLIUI=withdrawDepositOperationCLIUI;
        this.accountListingService=accountListingService;
    }
    public void depositMoney(String clientID){
        System.out.println("Enter your accountID: ");
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());
        if(account==null){
            System.out.println("There is no such accountID!");
            return;
        }
        System.out.println("Enter amount to deposit: ");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionDeposit.execute(account.getId(), amount);
    }
}