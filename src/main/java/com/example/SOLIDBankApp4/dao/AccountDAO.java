package com.example.SOLIDBankApp4.dao;

import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.account.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO{
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateNewAccount(Account accountWithdraw, Account account);
    Account getClientAccount(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
