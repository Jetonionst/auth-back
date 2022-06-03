package com.example.SOLIDBankApp4.entity.account;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, String clientID, double balance, long bankID) {
        super(AccountType.SAVING, id, clientID, balance, true, bankID);
    }
}