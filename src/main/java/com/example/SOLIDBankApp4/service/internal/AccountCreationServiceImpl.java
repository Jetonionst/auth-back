package com.example.SOLIDBankApp4.service.internal;

import com.example.SOLIDBankApp4.dao.AccountRepository;
import com.example.SOLIDBankApp4.entity.account.*;
import com.example.SOLIDBankApp4.service.AccountCreationService;
import org.springframework.stereotype.Service;

@Service
class AccountCreationServiceImpl implements AccountCreationService {
    //private final AccountDAO accountDAO;
    AccountRepository accountRepository;

    //AccountCreationServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    AccountCreationServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(String accountType, long bankID, String clientID, long accountID) {
        String accountNumber = String.format("%03d%06d", 1, accountID);
        Account account = null;
        switch (accountType) {
            case "FIXED":
                account = new FixedAccount(accountNumber, clientID, 0, bankID);
                break;
            case "SAVING":
                account = new SavingAccount(accountNumber, clientID, 0, bankID);
                break;
            case "CHECKING":
                account = new CheckingAccount(accountNumber, clientID, 0, bankID);
                break;
        }
        //accountDAO.createNewAccount(account);
        accountRepository.createNewAccount(account.getId(), accountType, account.getClientID(), account.getBalance(), account.getBankID(), account.isWithdrawAllowed());
        System.out.println("New Account was created!");
    }
}