package com.example.SOLIDBankApp4.service.internal;

import com.example.SOLIDBankApp4.dao.AccountRepository;
import com.example.SOLIDBankApp4.dao.TransactionRepository;
import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.service.AccountWithdrawService;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    //AccountDAO accountDAO;

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    //AccountWithdrawServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    AccountWithdrawServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void withdraw(double amount, String accountID) {
        //System.out.println(account.getAccountType());
        Account account = accountRepository.getClientAccount("1", accountID);
        switch (account.getAccountType()) {
            case FIXED:
                System.out.println("This is FIXED account! Withdraw is not allowed!");
                return;
            case SAVING, CHECKING:
                //Account newAccount = accountDAO.getClientAccount("1", String.valueOf(account.getId()));
                //double balance = accountDAO.getClientAccount("1", String.valueOf(account.getId())).getBalance();
                double balance = account.getBalance();
                if (balance >= amount) {
                    //newAccount.setBalance(balance - amount);
                    account.setBalance(balance - amount);
                    //accountDAO.updateNewAccount(account, newAccount);
                    accountRepository.updateNewAccount(account.getId(), account.getBalance());
                    transactionRepository.createNewTransaction("Withdraw", "1", account.getId(), amount, account.getBankID());
                    System.out.println("The amount was withdrawn!");
                } else {
                    System.out.println("The amount exceeds the balance!");
                }
                break;
        }
    }
}