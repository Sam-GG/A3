package com.example.a3;

import javafx.scene.layout.HBox;

public class MainUI extends HBox {
    public MainUI(ShapeToolbar shapeBar, ColourToolbar colorBar, DrawingView drawView){
        this.getChildren().addAll(shapeBar, colorBar, drawView);
    }
}
