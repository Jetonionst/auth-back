package com.example.SOLIDBankApp4.service;

import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.ui.CLIUI;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MyCLI implements CLIUI {
    private final Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        return Double.parseDouble(scanner.nextLine());
    }

    public String requestClientAccountNumber() {
        return scanner.nextLine();
    }

    public AccountType requestAccountType() {
        switch (scanner.nextLine()) {
            case "FIXED":
                return AccountType.FIXED;
            case "CHECKING":
                return AccountType.CHECKING;
            case "SAVING":
                return AccountType.SAVING;
        }
        return null;
    }

    public Scanner getScanner() {
        return scanner;
    }
}

