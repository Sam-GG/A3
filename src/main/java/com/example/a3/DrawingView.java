package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class DrawingView extends Pane {
    public DrawingView(){
        Canvas canvas = new Canvas();
        canvas.minWidth(500);
        canvas.minHeight(500);
        this.setMinWidth(500);
        this.setMinHeight(500);
        this.getChildren().add(canvas);
    }
}
