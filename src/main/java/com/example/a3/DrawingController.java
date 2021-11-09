package com.example.a3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DrawingController {
    DrawingModel model;
    InteractionModel iModel;

    public DrawingController() {
    }

    public void setModel(DrawingModel newModel) {
        model = newModel;
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
    }

    public void handlePressed(MouseEvent event) {
        model.addSquare(model.getCurrentColor(), 50, (int)event.getX(), (int)event.getY());
    }

    public void setCurrentColor(Color c){
        model.setCurrentColor(c);
    }

}