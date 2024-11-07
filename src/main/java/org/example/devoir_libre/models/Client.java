package org.example.devoir_libre.models;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    // Private fields for encapsulation
    private int numClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;
    private List<Compte> comptes ;

    // Static utility method to convert a Client object to JSON
    public static String toJson(Client client) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(client);
    }

    // Static utility method to convert JSON string to Client object
    public static Client fromJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, Client.class);
    }

    // Instance method to display client info
    public void displayInfo() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Prenom: " + this.prenom);
        System.out.println("Adresse: " + this.adresse);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
    }

    // Instance method to add a compte to the client's comptes list
    public void ajouterCompte(Compte compte) {
        this.comptes.add(compte);
    }

    public static void main(String[] args) {

    }
}

