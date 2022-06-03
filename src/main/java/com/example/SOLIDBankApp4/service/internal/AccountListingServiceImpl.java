package com.example.SOLIDBankApp4.service.internal;

import com.example.SOLIDBankApp4.dao.AccountRepository;
import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.account.AccountWithdraw;
import com.example.SOLIDBankApp4.service.AccountListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    //private final AccountDAO accountDAO;

    private AccountRepository accountRepository;

    //public AccountListingServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    public AccountListingServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        //return accountDAO.getClientAccount(clientID, accountID);
        return accountRepository.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        //return accountDAO.getClientWithdrawAccount(clientID, accountID);
        return accountRepository.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        //return accountDAO.getClientAccounts(clientID);
        return accountRepository.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.getClientAccountsByType(clientID, accountType);
    }

}