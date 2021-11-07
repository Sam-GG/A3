package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ShapeToolbar extends VBox {
    public ShapeToolbar(){
        Button rect = new Button("Rect");
        Button square = new Button("Square");
        Button circle = new Button("Circle");
        Button oval = new Button("Oval");
        Button line = new Button("Line");
        this.setSpacing(5);
        this.getChildren().addAll(rect, square, circle, oval, line);
    }
}
