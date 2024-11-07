package org.example.devoir_libre.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private int idTransaction;
    private Compte sourceAccount;
    private Compte destinationAccount;
    private double amount;
    private Date transactionDate;
    private TransactionType type;

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", sourceAccount=" + sourceAccount.getNumCompte() +
                ", destinationAccount=" + destinationAccount.getNumCompte() +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}

enum TransactionType {
    VIRMULTA, // Same country, same bank
    VIREST,   // Same country, different bank
    VIRINI,   // Different country, same bank
    VIRCHAC   // Different country, different bank
}
