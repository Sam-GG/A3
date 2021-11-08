package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColourToolbar extends VBox {
    public ColourToolbar(){
        Button aqua = new Button("Aqua");
        aqua.setStyle("-fx-background-color: Aqua;");
        Button violet = new Button("Violet");
        violet.setStyle("-fx-background-color: violet");
        Button green = new Button("Green");
        green.setStyle("-fx-background-color: green");
        Button gold = new Button("Gold");
        gold.setStyle("-fx-background-color: gold");
        Button orange = new Button("Orange");
        orange.setStyle("-fx-background-color: orange");
        Button coral = new Button("Coral");
        coral.setStyle("-fx-background-color: coral");
        Button fuchsia = new Button("Fuchsia");
        fuchsia.setStyle("-fx-background-color: fuchsia");
        Button peru = new Button("Peru");
        peru.setStyle("-fx-background-color: peru");

        this.getChildren().addAll(aqua, violet, green, gold, orange, coral, fuchsia, peru);
        this.getStylesheets().add("colorToolbarStyle.css");
    }
}
