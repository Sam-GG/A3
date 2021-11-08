package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShapeToolbar extends VBox {
    public ShapeToolbar(){
        Button rect = new Button("Rect");
        Rectangle r = new Rectangle(); r.setWidth(50); r.setHeight(25); rect.setGraphic(r);

        Button square = new Button("Square");
        Rectangle s = new Rectangle(); s.setWidth(25); s.setHeight(25); square.setGraphic(s);

        Button circle = new Button("Circle");
        Circle c = new Circle(); c.setRadius(20); circle.setGraphic(c);

        Button oval = new Button("Oval");
        Circle o = new Circle(); o.setRadius(20); o.setScaleY(0.6); oval.setGraphic(o);

        Button line = new Button("Line");
        Line l = new Line(); l.setScaleY(1); l.setScaleX(20); l.setRotate(45); line.setGraphic(l);

        this.getChildren().addAll(rect, square, circle, oval, line);
        this.getStylesheets().add("shapeToolbarStyle.css");
    }
}