package org.example.devoir_libre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compte {
    private int numCompte;
    private double solde;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateUpdate;

    private Devise devise;
    private Banque banque;

    @JsonBackReference
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

    // Convertir un objet Compte en JSON
    public static String toJson(Compte compte) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(compte);
    }

    // Convertir un JSON en objet Compte
    public static Compte fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Compte.class);
    }
}
