package com.example.SOLIDBankApp4.service;

import org.springframework.stereotype.Service;

@Service
public class BankCore {
    private static final long id = 1;
    private long lastAccountNumber = 1;
    private final AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreation = accountCreationService;
    }

    public void createNewAccount(String accountType, String clientID) {
        if (accountType == null) {
            System.out.println("There is no such account type!");
            return;
        }
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber += 1;
    }
}
