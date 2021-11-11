package com.example.a3;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShapeToolbar extends VBox {
    public ToggleGroup toggleGroup;
    DrawingController controller;

    public ShapeToolbar(){
        ToggleButton rect = new ToggleButton("Rect");
        Rectangle r = new Rectangle(); r.setWidth(50); r.setHeight(25); rect.setGraphic(r);
        r.setFill(Color.AQUA);
        rect.setOnAction(e -> controller.updateShapeButtonColor());
        rect.setSelected(true);

        ToggleButton square = new ToggleButton("Square");
        Rectangle s = new Rectangle(); s.setWidth(25); s.setHeight(25); square.setGraphic(s);
        square.setOnAction(e -> controller.updateShapeButtonColor());

        ToggleButton circle = new ToggleButton("Circle");
        Circle c = new Circle(); c.setRadius(20); circle.setGraphic(c);
        circle.setOnAction(e -> controller.updateShapeButtonColor());

        ToggleButton oval = new ToggleButton("Oval");
        Circle o = new Circle(); o.setRadius(20); o.setScaleY(0.6); oval.setGraphic(o);
        oval.setOnAction(e -> controller.updateShapeButtonColor());

        ToggleButton line = new ToggleButton("Line");
        Rectangle l = new Rectangle(); l.setWidth(25); l.setHeight(1); l.setRotate(45); line.setGraphic(l);
        line.setOnAction(e -> controller.updateShapeButtonColor());

        toggleGroup = new ToggleGroup();
        rect.setToggleGroup(toggleGroup); rect.setUserData("rectangle");
        square.setToggleGroup(toggleGroup); square.setUserData("square");
        circle.setToggleGroup(toggleGroup); circle.setUserData("circle");
        oval.setToggleGroup(toggleGroup); oval.setUserData("oval");
        line.setToggleGroup(toggleGroup); line.setUserData("line");

        this.getChildren().addAll(rect, square, circle, oval, line);
        this.getStylesheets().add("shapeToolbarStyle.css");
    }

    public void setController(DrawingController controller) {
        this.controller = controller;
    }
}