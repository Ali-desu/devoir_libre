package org.example.devoir_libre.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.devoir_libre.JsonConverter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    private int numClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;

    @JsonManagedReference
    private List<Compte> comptes;

    public Client(int id, String nom) {
        this.numClient = id;
        this.nom = nom;
        this.comptes = new ArrayList<>(); // Initialize the list to avoid null pointer exceptions
    }

    public String toJson() {
        return JsonConverter.toJson(this);
    }

    // Convertir un JSON en objet Client
    public static Client fromJson(String json) {
        return JsonConverter.fromJson(json, Client.class);
    }

    public void displayInfo() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Prenom: " + this.prenom);
        System.out.println("Adresse: " + this.adresse);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
    }

    public void ajouterCompte(Compte compte) {
        this.comptes.add(compte);
    }
}
