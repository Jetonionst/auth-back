package com.example.SOLIDBankApp4.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, String accountID);
}