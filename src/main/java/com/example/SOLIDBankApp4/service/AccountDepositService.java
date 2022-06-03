package com.example.SOLIDBankApp4.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, String accountID);
}
