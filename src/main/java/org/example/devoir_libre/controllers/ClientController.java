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
    private ComboBox<Devise> deviseComboBox; // For selecting currency
    @FXML
    private DatePicker dateCreationField;    // For selecting account creation date

    @FXML
    private Button addClientButton;           // Button to add client

    @FXML
    private Label messageLabel;               // For displaying the confirmation message

    public void initialize() {
        // Populate the ComboBox with Devise enum values
        deviseComboBox.setItems(FXCollections.observableArrayList(Devise.values()));
    }

    // This method will be called when the "Add Client" button is clicked
    @FXML
    public void handleAddClient() {
        // Gather all the client input fields
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        Devise devise = deviseComboBox.getValue();
        Date dateCreation = java.sql.Date.valueOf(dateCreationField.getValue());  // Convert DatePicker to Date

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || phone.isEmpty() || email.isEmpty() || devise == null || dateCreation == null) {
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

        // Now create a new Compte for the client
        Banque banque = new Banque(); // You should define this class, assuming it's defined somewhere
        banque.setPays("Some Country"); // Set the country for the bank (or use a real value)

        Compte newCompte = new Compte(1, new Date(), new Date(), devise, banque); // Creating a new account
        newClient.ajouterCompte(newCompte); // Adding the account to the client

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
        deviseComboBox.getSelectionModel().clearSelection();
        dateCreationField.setValue(null);
    }
}
