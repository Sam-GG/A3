package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ColourToolbar extends VBox {
    public ColourToolbar(){
        Button aqua = new Button("Aqua");
        Button violet = new Button("Violet");
        Button green = new Button("Green");
        Button gold = new Button("Gold");
        Button orange = new Button("Orange");
        Button coral = new Button("Coral");
        Button fuchsia = new Button("Fuchsia");
        Button peru = new Button("Peru");
        this.setSpacing(5);
        this.getChildren().addAll(aqua, violet, green, gold, orange, coral, fuchsia, peru);
    }
}
