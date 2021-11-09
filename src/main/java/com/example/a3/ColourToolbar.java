package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColourToolbar extends VBox {
    DrawingController controller;

    public ColourToolbar(){
        Button aqua = new Button("Aqua");
        aqua.setStyle("-fx-background-color: Aqua;");
        aqua.setOnAction(actionEvent -> controller.setCurrentColor(Color.AQUA));

        Button violet = new Button("Violet");
        violet.setStyle("-fx-background-color: violet");
        violet.setOnAction(actionEvent -> controller.setCurrentColor(Color.VIOLET));

        Button green = new Button("Green");
        green.setStyle("-fx-background-color: green");
        green.setOnAction(actionEvent -> controller.setCurrentColor(Color.GREEN));

        Button gold = new Button("Gold");
        gold.setStyle("-fx-background-color: gold");
        gold.setOnAction(actionEvent -> controller.setCurrentColor(Color.GOLD));

        Button orange = new Button("Orange");
        orange.setStyle("-fx-background-color: orange");
        orange.setOnAction(actionEvent -> controller.setCurrentColor(Color.ORANGE));

        Button coral = new Button("Coral");
        coral.setStyle("-fx-background-color: coral");
        coral.setOnAction(actionEvent -> controller.setCurrentColor(Color.CORAL));

        Button fuchsia = new Button("Fuchsia");
        fuchsia.setStyle("-fx-background-color: fuchsia");
        fuchsia.setOnAction(actionEvent -> controller.setCurrentColor(Color.FUCHSIA));

        Button peru = new Button("Peru");
        peru.setStyle("-fx-background-color: peru");
        peru.setOnAction(actionEvent -> controller.setCurrentColor(Color.PERU));

        this.getChildren().addAll(aqua, violet, green, gold, orange, coral, fuchsia, peru);
        this.getStylesheets().add("colorToolbarStyle.css");
    }

    public void setController(DrawingController controller){
        this.controller = controller;
    }
}
