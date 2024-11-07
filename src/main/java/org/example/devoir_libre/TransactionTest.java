package org.example.devoir_libre;

import org.example.devoir_libre.models.*;

import java.util.ArrayList;
import java.util.Date;

public class TransactionTest {

    public static void main(String[] args) {
        // Create bank instances for testing
        Banque banque1 = new Banque(1,  "USA ");
        Banque banque2 = new Banque(2, "USA");

        // Create client instances
        Client client1 = new Client(1, "John Doe");
        Client client2 = new Client(2, "Jane Smith");

        // Create accounts with initial balances
        Compte compte1 = new Compte(1, 1000.0, new Date(), null, Devise.MAD, banque1, client1, new ArrayList<>());
        Compte compte2 = new Compte(2, 500.0, new Date(), null, Devise.USD, banque2, client2, new ArrayList<>());

        // Display initial balances
        System.out.println("Initial Balances:");
        System.out.println("Compte1 (Client 1) Balance: " + compte1.getSolde());
        System.out.println("Compte2 (Client 2) Balance: " + compte2.getSolde());

        // Test transaction between compte1 and compte2
        System.out.println("\nPerforming Transaction of 200.0 from Compte1 to Compte2...");
        boolean transactionSuccess = compte1.makeTransaction(compte2, 200.0);

        if (transactionSuccess) {
            // Display transaction details
            System.out.println("\nTransaction Details:");
            System.out.println("Compte1 Transactions: " + compte1.getTransactions());
            System.out.println("Compte2 Transactions: " + compte2.getTransactions());

            // Display updated balances
            System.out.println("\nUpdated Balances:");
            System.out.println("Compte1 (Client 1) Balance: " + compte1.getSolde());
            System.out.println("Compte2 (Client 2) Balance: " + compte2.getSolde());
        } else {
            System.out.println("Transaction failed due to insufficient balance.");
        }
    }
}

