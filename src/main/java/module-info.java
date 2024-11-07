module org.example.devoir_libre {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.gson;
    requires java.sql;


    opens org.example.devoir_libre to javafx.fxml;
    exports org.example.devoir_libre;
    exports org.example.devoir_libre.controllers;
    opens org.example.devoir_libre.controllers to javafx.fxml;
}