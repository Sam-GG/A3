package com.example.a3;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Optional;

public class DrawingController {
    DrawingModel model;
    InteractionModel iModel;
    ToggleGroup toggleGroup;
    DrawingView drawingView;
    boolean drawingNew = true;
    int dragStartX;
    int dragStartY;

    public DrawingController() {
    }

    public void setDrawingView(DrawingView drawingView){
        this.drawingView = drawingView;
    }

    public void setModel(DrawingModel newModel) {
        model = newModel;
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
    }

    public void handlePressed(MouseEvent event) {
        this.dragStartX = (int)event.getX();
        this.dragStartY = (int)event.getY();
        if (!model.getItem((int)event.getX(), (int)event.getY()).isEmpty()){
            model.bringShapeToFront(model.getItem((int)event.getX(), (int)event.getY()).get());
            this.drawingNew = false;
        }else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            this.drawingNew = true;
            try {
                String selectedShape = toggleGroup.getSelectedToggle().getUserData().toString();
                switch (selectedShape) {
                    case "rectangle":
                        model.addRect(25, 20, (int) event.getX(), (int) event.getY());
                        break;
                    case "circle":
                        model.addCircle(25, 25, (int) event.getX(), (int) event.getY());
                        break;
                    case "square":
                        model.addSquare(25, 25, (int) event.getX(), (int) event.getY());
                        break;
                    case "oval":
                        model.addOval(25, 20, (int) event.getX(), (int) event.getY());
                        break;
                    case "line":
                        model.addLine(50, 3, (int) event.getX(), (int) event.getY());
                        break;
                    default:
                        System.out.println("Select a shape");
                }
            } catch (Exception e) {
                System.out.println("Shape not selected");
                System.out.println(e);
            }

        }

    }

    public void handleDrag(MouseEvent event) {
        if (drawingNew) {
            boolean xFlipped = false;
            boolean yFlipped = false;
            if ((event.getX() - dragStartX) < 0) {
                xFlipped = true;
            }
            if ((event.getY() - dragStartY) < 0) {
                yFlipped = true;
            }
            model.setCurrentShapeDrag((int) dragStartX, (int) dragStartY, (int) event.getX(), (int) event.getY(), xFlipped, yFlipped);
        } else{
            model.moveShape((int)event.getX(), (int)event.getY());
        }
    }

    public void setCurrentColor(Color c){
        model.setCurrentColor(c);
        updateShapeButtonColor();
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    public void updateShapeButtonColor() {
        Color c = model.getCurrentColor();
        toggleGroup.getToggles().forEach(item->{
            ToggleButton t = (ToggleButton)item;
            t.getGraphic().setStyle("-fx-fill: Black");
        });
        ToggleButton selected = (ToggleButton)toggleGroup.getSelectedToggle();
        selected.getGraphic().setStyle("-fx-fill: "+"'"+c.toString()+"'");
    }
}