package org.example.devoir_libre.models;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Banque {
    private ArrayList<Compte> comptes; // List of comptes in this bank
    private int id;
    private String pays;

    // Method to add a Compte to the banque's list
    public void addCompte(Compte compte) {
        if (comptes == null) {
            comptes = new ArrayList<>();
        }
        comptes.add(compte);
    }

    @Override
    public String toString() {
        return pays; // Display the country name in ComboBox
    }
}
