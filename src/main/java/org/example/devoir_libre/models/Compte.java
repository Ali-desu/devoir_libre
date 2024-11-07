package org.example.devoir_libre.models;

import lombok.*;

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
    private ArrayList<Transaction> transactions;

    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", banque=" + banque.getPays() +  // Display the country name of the banque
                '}';
    }

}


