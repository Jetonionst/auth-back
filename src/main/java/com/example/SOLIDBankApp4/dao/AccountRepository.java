package com.example.SOLIDBankApp4.dao;

import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.account.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("SELECT * FROM Account WHERE client_id = :clientID")
    List<Account> getClientAccounts(String clientID);

    @Modifying
    @Query("INSERT INTO Account(id, account_type, client_id, balance, withdraw_allowed, bank_id) " +
            "VALUES(:id, :accountType, :clientID, :balance, :withdrawAllowed, :bankID)")
    void createNewAccount(String id, String accountType, String clientID, double balance, long bankID, boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Account SET balance = :balance WHERE id = :id")
    void updateNewAccount(String id, double balance);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND id = :accountID")
    Account getClientAccount(String clientID, String accountID);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND id = :accountID AND withdraw_allowed = 'false'")
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_type = :accountType")
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    @Modifying
    @Query("DELETE FROM Account WHERE client_id = :clientID AND id = :accountID")
    void deleteAccount(String clientID, String accountID);
}
