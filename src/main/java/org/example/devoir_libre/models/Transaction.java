package org.example.devoir_libre.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Transaction {
    private TransactionType type; // Transaction type
    private Compte sourceCompte;  // Account from which money is being sent
    private Compte destinationCompte;  // Account to which money is being sent
    private double amount;  // The amount of the transaction
    private Date transactionDate;
}

enum TransactionType {
    VIRINI,
    VIREST,
    VIRMULTA,
    VIRCHAC
}
