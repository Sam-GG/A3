package com.example.a3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainUI mainUI = new MainUI(new ShapeToolbar(), new ColourToolbar(), new DrawingView());
        Scene scene = new Scene(mainUI);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}