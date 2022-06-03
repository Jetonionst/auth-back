package com.example.SOLIDBankApp4.entity.account;

public class AccountWithdraw extends Account {
    AccountWithdraw(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed, long bankID) {
        super(accountType, id, clientID, balance, withdrawAllowed, bankID);
    }
}