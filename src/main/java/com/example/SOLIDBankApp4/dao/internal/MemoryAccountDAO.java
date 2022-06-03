package com.example.SOLIDBankApp4.dao.internal;

import com.example.SOLIDBankApp4.dao.AccountDAO;
import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.account.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryAccountDAO implements AccountDAO {
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateNewAccount(Account accountOld, Account accountNew) {
        this.accountList.set(accountList.indexOf(accountOld), accountNew);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account temp : accountList) {
            if(temp.getClientID().equals(clientID) && temp.getId().equals(accountID)){ return temp; }
        }
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for (Account temp : accountList) {
            if(temp.getClientID().equals(clientID) && temp.getId().equals(accountID) && !temp.getAccountType().equals(AccountType.FIXED)){ return (AccountWithdraw) temp; }
        }
        return null;
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> list = new ArrayList<>();
        for (Account temp : accountList) {
            if(temp.getClientID().equals(clientID) && temp.getAccountType().equals(accountType)){ list.add(temp); }
        }
        return list;
    }
}