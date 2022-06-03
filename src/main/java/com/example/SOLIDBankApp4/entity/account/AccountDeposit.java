package com.example.SOLIDBankApp4.entity.account;

class AccountDeposit extends Account {
    AccountDeposit(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed,long bankID) {
        super(accountType, id, clientID, balance, withdrawAllowed, bankID);
    }

}