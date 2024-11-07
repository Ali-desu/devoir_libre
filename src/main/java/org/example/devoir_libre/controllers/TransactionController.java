package org.example.devoir_libre.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.devoir_libre.models.Compte;
import org.example.devoir_libre.models.Transaction;

public class TransactionController {

    @FXML
    private TextField sourceAccountIdField;

    @FXML
    private TextField destinationAccountIdField;

    @FXML
    private TextField amountField;

    @FXML
    private Label resultLabel;

    @FXML
    private Button submitButton;

    @FXML
    public void handleTransaction() {
        try {
            int sourceId = Integer.parseInt(sourceAccountIdField.getText());
            int destinationId = Integer.parseInt(destinationAccountIdField.getText());
            double amount = Double.parseDouble(amountField.getText());

            Compte sourceAccount = findAccountById(sourceId);
            Compte destinationAccount = findAccountById(destinationId);

            if (sourceAccount != null && destinationAccount != null) {
                boolean success = sourceAccount.makeTransaction(destinationAccount, amount);
                if (success) {
                    resultLabel.setText("Transaction Successful!");
                    resultLabel.setTextFill(javafx.scene.paint.Color.GREEN);
                } else {
                    resultLabel.setText("Transaction Failed: Insufficient Balance");
                    resultLabel.setTextFill(javafx.scene.paint.Color.RED);
                }
            } else {
                resultLabel.setText("Error: One or both accounts not found.");
                resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Invalid input. Please enter valid numbers.");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
        }
    }

    private Compte findAccountById(int id) {
        // This is a placeholder method. Replace with your actual account retrieval logic
        return null; // Replace with the logic to find account by ID
    }
}
