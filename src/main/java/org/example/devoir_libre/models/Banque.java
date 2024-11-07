package org.example.devoir_libre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.example.devoir_libre.JsonConverter;

import java.io.IOException;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Banque {
    @JsonBackReference
    private ArrayList<Compte> comptes;

    private int id;
    private String pays;

    public Banque(int id, String pays) {
        this.id = id;
        this.pays = pays;
    }

    // Method to add a Compte to the banque's list
    public void addCompte(Compte compte) {
        if (comptes == null) {
            comptes = new ArrayList<>();
        }
        comptes.add(compte);
    }

    // Convertir un objet Client en JSON
    public String toJson() {
        return JsonConverter.toJson(this);
    }

    @Override
    public String toString() {
        return pays; // Display the country name in ComboBox
    }
}
