package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DrawingView extends StackPane {
    Canvas myCanvas;
    GraphicsContext gc;

    public DrawingView(){
        myCanvas = new Canvas();
        gc = myCanvas.getGraphicsContext2D();
        myCanvas.minWidth(500);
        myCanvas.minHeight(500);
        this.setMinWidth(500);
        this.setMinHeight(500);
        this.getChildren().add(myCanvas);
        draw();
    }

    public void draw(){
        gc.setFill(Color.RED);
        gc.fillOval(20, 20, 20, 20);
    }
}
