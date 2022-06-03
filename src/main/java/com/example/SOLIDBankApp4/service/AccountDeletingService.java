package com.example.SOLIDBankApp4.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountDeletingService {
    void delete(String clientID, String accountID);
}
