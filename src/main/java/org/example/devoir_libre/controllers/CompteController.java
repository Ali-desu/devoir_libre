package org.example.devoir_libre.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import org.example.devoir_libre.models.Client;
import org.example.devoir_libre.models.Compte;
import org.example.devoir_libre.models.Devise;

import java.time.LocalDate;
import java.util.Date;

public class CompteController {

    @FXML
    private DatePicker dateCreationPicker;
    @FXML
    private ComboBox<Devise> deviseComboBox;
    @FXML
    private TextField bankIdField;
    @FXML
    private TextField clientIdField;

    @FXML
    public void initialize() {
        // Populate Devise ComboBox
        deviseComboBox.setItems(FXCollections.observableArrayList(Devise.values()));
    }

    @FXML
    public void handleAddCompte() {
        // Get and validate input
        LocalDate dateCreation = dateCreationPicker.getValue();
        Devise selectedDevise = deviseComboBox.getValue();
        String bankId = bankIdField.getText();
        String clientId = clientIdField.getText();

        if (dateCreation == null || selectedDevise == null || bankId.isEmpty() || clientId.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        // Create Compte object
        Compte newCompte = new Compte();
        newCompte.setDateCreation(java.sql.Date.valueOf(dateCreation));
        newCompte.setDateUpdate(new Date());  // Set to current date
        newCompte.setDevise(selectedDevise);

        // Here, you would normally look up the Banque and Client by their IDs
        // For now, let's assume they are set with placeholder or dummy objects
        // newCompte.setBanque(findBanqueById(bankId));
        // Client client = findClientById(clientId);
        // client.ajouterCompte(newCompte);

        showConfirmation("Compte ajouté avec succès !");
        clearFields();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        dateCreationPicker.setValue(null);
        deviseComboBox.getSelectionModel().clearSelection();
        bankIdField.clear();
        clientIdField.clear();
    }
}
