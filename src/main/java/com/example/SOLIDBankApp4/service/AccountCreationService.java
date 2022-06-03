package com.example.SOLIDBankApp4.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    default void create(String accountType, long bankID, String clientID, long accountID) {}
}
