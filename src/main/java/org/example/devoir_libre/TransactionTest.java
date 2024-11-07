package org.example.devoir_libre;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.devoir_libre.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TransactionTest {

    public static void main(String[] args) {
        // 1. Create instances of the relevant classes
        Banque banque1 = new Banque(1, "USA");
        Banque banque2 = new Banque(2, "Canada");

        // Creating a client and assigning comptes to them
        Client client1 = new Client(1, "John");
        Client client2 = new Client(2, "Jane");

        Compte compte1 = new Compte(1, 5000.0, new Date(), new Date(), Devise.MAD, banque1, client1, new ArrayList<>());
        Compte compte2 = new Compte(2, 3000.0, new Date(), new Date(), Devise.USD, banque2, client2, new ArrayList<>());
        banque1.addCompte(compte1);
        banque2.addCompte(compte2);

        // 2. Create a Transaction between the two comptes
        boolean transactionSuccessful = compte1.makeTransaction(compte2, 1000.0);
        System.out.println("Transaction success: " + transactionSuccessful);

        String clientJson = JsonConverter.toJson(client1);
        String banqueJson = JsonConverter.toJson(banque1);
        String transactionJson = JsonConverter.toJson(compte1.getTransactions().getFirst());

        System.out.println("Client JSON: " + clientJson);
        System.out.println("Banque JSON: " + banqueJson);
        System.out.println("Transaction JSON: " + transactionJson);

    }
}
