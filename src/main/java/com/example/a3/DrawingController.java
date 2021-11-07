package com.example.a3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DrawingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}