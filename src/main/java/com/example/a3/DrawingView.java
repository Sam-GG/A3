package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class DrawingView extends Pane {
    public DrawingView(){
        Canvas canvas = new Canvas();
        canvas.minWidth(350);
        canvas.minHeight(200);
        this.setMinWidth(350);
        this.setMinHeight(200);
        this.getChildren().add(canvas);
    }
}
