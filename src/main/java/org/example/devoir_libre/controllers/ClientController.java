package org.example.devoir_libre.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import org.example.devoir_libre.models.Client;
import org.example.devoir_libre.models.Compte;
import org.example.devoir_libre.models.Devise;
import org.example.devoir_libre.models.Banque;

import java.util.ArrayList;
import java.util.Date;

public class ClientController {

    @FXML
    private TextField nomField;       // For client name input
    @FXML
    private TextField prenomField;    // For client surname input
    @FXML
    private TextField adresseField;   // For client address input
    @FXML
    private TextField phoneField;     // For client phone input
    @FXML
    private TextField emailField;     // For client email input
    @FXML
    private Label messageLabel;               // For displaying the confirmation message



    // This method will be called when the "Add Client" button is clicked
    @FXML
    public void handleAddClient() {
        // Gather all the client input fields
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();


        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            messageLabel.setText("Please fill out all fields.");
            return;
        }

        // Create a new client and add to a list
        Client newClient = new Client();
        newClient.setNom(nom);
        newClient.setPrenom(prenom);
        newClient.setAdresse(adresse);
        newClient.setPhone(phone);
        newClient.setEmail(email);
        newClient.setComptes(new ArrayList<>());

        // Simulate saving to a database or list (in this case, we just show a confirmation)
        messageLabel.setText("Client Added Successfully!");

        // Clear fields for next input
        clearFields();
    }

    private void clearFields() {
        // Clear all the fields after adding the client
        nomField.clear();
        prenomField.clear();
        adresseField.clear();
        phoneField.clear();
        emailField.clear();
    }
}
