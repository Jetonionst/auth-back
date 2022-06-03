package com.example.SOLIDBankApp4.service.internal;

import com.example.SOLIDBankApp4.dao.AccountRepository;
import com.example.SOLIDBankApp4.service.AccountDeletingService;
import org.springframework.stereotype.Service;

@Service
public class AccountDeletingServiceImpl implements AccountDeletingService {

    AccountRepository accountRepository;

    public AccountDeletingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void delete(String clientID, String accountID) {
        accountRepository.deleteAccount(clientID, accountID);
    }
}
