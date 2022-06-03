package com.example.SOLIDBankApp4.entity.cli;

import com.example.SOLIDBankApp4.entity.ui.CreateAccountOperationUI;
import com.example.SOLIDBankApp4.service.AccountListingService;
import com.example.SOLIDBankApp4.service.BankCore;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI{
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListingService;

    AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListingService){
        this.accountListingService = accountListingService;
        this.bankCore = bankCore;
        this.createAccountOperationUI = createAccountOperationUI;
    }

    public void createAccountRequest(String clientID){
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType().name(), clientID);
    }
    public void getAccounts(String clientID){
        System.out.println(accountListingService.getClientAccounts(clientID));
    }
}