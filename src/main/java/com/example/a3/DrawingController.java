package com.example.a3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DrawingController {
    DrawingModel model;
    InteractionModel iModel;
    ToggleGroup toggleGroup;

    public DrawingController() {
    }

    public void setModel(DrawingModel newModel) {
        model = newModel;
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
    }

    public void handlePressed(MouseEvent event) {
        try {
            String selectedShape = toggleGroup.getSelectedToggle().getUserData().toString();
            switch(selectedShape) {
                case "rectangle":
                    model.addRect(25, 20, (int)event.getX(), (int)event.getY());
                    break;
                case "circle":
                    model.addCircle(25, (int)event.getX(), (int)event.getY());
                    break;
                case "square":
                    model.addSquare(25, (int)event.getX(), (int)event.getY());
                    break;
                case "oval":
                    model.addOval(25, 20, (int)event.getX(), (int)event.getY());
                    break;
                case "line":
                    model.addLine(50, (int)event.getX(), (int)event.getY());
                    break;
                default:
                    System.out.println("Select a shape");
            }
        } catch(Exception e){
            System.out.println("Shape not selected");
            System.out.println(e);
        }
    }

//    public void handlePressed(MouseDragEvent event) {
//        model.addSquare(model.getCurrentColor(), 5, (int)event.getX(), (int)event.getY());
//    }

    public void setCurrentColor(Color c){
        model.setCurrentColor(c);
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }
}