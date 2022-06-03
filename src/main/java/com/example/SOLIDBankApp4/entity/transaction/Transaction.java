package com.example.SOLIDBankApp4.entity.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private String transactionType;
    private String clientID;
    private String accountID;
    private double amount;
    private long bankID;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType='" + transactionType + '\'' +
                ", clientID='" + clientID + '\'' +
                ", accountID='" + accountID + '\'' +
                ", amount=" + amount +
                ", bankID=" + bankID +
                '}';
    }
}