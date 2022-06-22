package com.example.SOLIDBankApp4.service.controller;

import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.exceptions.AccountNotFound;
import com.example.SOLIDBankApp4.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private BankCore bankCore;
    private AccountListingService accountListingService;
    private AccountWithdrawService accountWithdrawService;
    private AccountDepositService accountDepositService;
    private AccountDeletingService accountDeletingService;


    @GetMapping
    public List<Account> getClientAccounts(@RequestParam String clientID){
        return accountListingService.getClientAccounts(clientID);
    }

    @GetMapping("/{accountID}")
    public Account getClientAccount(@RequestParam String clientID, @PathVariable String accountID) throws Exception {
        Account account = accountListingService.getClientAccount(clientID, accountID);
        if(account==null){
            throw new AccountNotFound("This account does not exist!");
        }
        return account;
    }

    @PostMapping
    public void createNewAccount(@RequestParam String accountType, @RequestParam String clientID){
        bankCore.createNewAccount(accountType, clientID);
    }

    @PostMapping("/{accountID}/deposit")
    public void deposit(@RequestParam double amount, @PathVariable String accountID){
        accountDepositService.deposit(amount, accountID);
    }

    @PostMapping("/{accountID}/withdraw")
    public void withdraw(@RequestParam double amount, @PathVariable String accountID){
        accountWithdrawService.withdraw(amount, accountID);
    }

    @DeleteMapping("/{accountID}")
    public void deleteAccount(@RequestParam String clientID, @PathVariable String accountID){
        accountDeletingService.delete(clientID, accountID);
    }
}
