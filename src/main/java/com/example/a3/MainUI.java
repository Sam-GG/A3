package com.example.a3;

import javafx.scene.layout.BorderPane;

public class MainUI extends BorderPane {
    public MainUI(ShapeToolbar shapeBar, ColourToolbar colorBar, DrawingView drawView){
        this.setLeft(shapeBar);
        drawView.setMinSize(100, 100);
        drawView.setMaxSize(4096, 2160);
        this.setCenter(drawView);
        this.setRight(colorBar);
    }
}
