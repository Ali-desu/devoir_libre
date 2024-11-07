package org.example.devoir_libre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.devoir_libre.MainApp;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    Button btnScene1 , btnScene2 , btnScene3 ;


    public void openClientForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("client-view.fxml"));
        Stage window = (Stage) btnScene1.getScene().getWindow();

        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    public void openAccountForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("compte-view.fxml"));
        Stage window = (Stage) btnScene2.getScene().getWindow();

        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    public void openTransactionForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("transaction-view.fxml"));
        Stage window = (Stage) btnScene3.getScene().getWindow();

        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }
}