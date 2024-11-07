package org.example.devoir_libre.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compte {
    private int numCompte;
    private double solde;
    private Date dateCreation;
    private Date dateUpdate;
    private Devise devise;
    private Banque banque;
    private Client client;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", banque=" + banque.getPays() +
                '}';
    }

    public boolean makeTransaction(Compte destinationAccount, double amount) {
        if (this.solde < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }

        TransactionType type = determineTransactionType(destinationAccount);

        // Deduct amount from source account and add to destination account
        this.solde -= amount;
        destinationAccount.solde += amount;

        // Create the transaction object
        Transaction transaction = new Transaction(
                transactions.size() + 1,
                this,
                destinationAccount,
                amount,
                new Date(),
                type
        );

        // Add the transaction to both accounts' transaction lists
        this.transactions.add(transaction);
        destinationAccount.transactions.add(transaction);

        System.out.println("Transaction successful: " + transaction);
        return true;
    }

    private TransactionType determineTransactionType(Compte destinationAccount) {
        boolean sameCountry = this.banque.getPays().equals(destinationAccount.getBanque().getPays());
        boolean sameBank = this.banque.equals(destinationAccount.getBanque());

        if (sameCountry && sameBank) return TransactionType.VIRMULTA;
        if (sameCountry) return TransactionType.VIREST;
        if (sameBank) return TransactionType.VIRINI;
        return TransactionType.VIRCHAC;
    }
}
