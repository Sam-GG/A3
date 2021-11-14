package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DrawingView extends StackPane implements DrawingModelSubscriber{
    Canvas myCanvas;
    GraphicsContext gc;
    DrawingModel model;
    InteractionModel iModel;
    Boolean isMini;

    public void setModel(DrawingModel newModel) {
        this.model = newModel;
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
        iModel.setViewSize(myCanvas.getWidth(), myCanvas.getHeight());
    }

    public void setController(DrawingController controller) {
        myCanvas.setOnMousePressed(controller::handlePressed);
        myCanvas.setOnMouseDragged(controller::handleDrag);
        myCanvas.setOnMouseReleased(controller::handleReleased);
    }

    public DrawingView(int width, int height){
        isMini = false;
        myCanvas = new Canvas(width, height);
        gc = myCanvas.getGraphicsContext2D();
        this.getChildren().add(myCanvas);
        this.widthProperty().addListener((observable, oldVal, newVal) -> {
            myCanvas.setWidth(newVal.doubleValue());
            iModel.setViewSize(myCanvas.getWidth(), myCanvas.getHeight());
            this.setWidth(newVal.doubleValue());
            draw();
        });
        this.heightProperty().addListener((observable, oldVal, newVal) -> {
            myCanvas.setHeight(newVal.doubleValue());
            iModel.setViewSize(myCanvas.getWidth(), myCanvas.getHeight());
            this.setHeight(newVal.doubleValue());
            draw();
        });

    }

    public void draw(){
        gc.clearRect(gc.getCanvas().getLayoutX(),
                gc.getCanvas().getLayoutY(),
                gc.getCanvas().getWidth(),
                gc.getCanvas().getHeight());

        model.getItems().forEach(item -> {
            switch (item) {
                case XCircle circle -> this.drawCircle(circle);
                case XSquare square -> this.drawSquare(square);
                case XRectangle rect -> {this.drawRect(rect);}
                case XOval oval -> this.drawOval(oval);
                case XLine line -> this.drawLine(line);
                default -> throw new IllegalStateException("Unexpected value: " + item);
            }
        });
    }

    public void drawCircle(XCircle circle) {
//        double drawCoefficientX = gc.getCanvas().getWidth()/(double)500;
//        double drawCoefficientY = gc.getCanvas().getHeight()/(double)500;

        gc.setFill(circle.getColor());
        gc.fillOval(circle.x_coord, circle.y_coord, circle.getWidth(), circle.getHeight());
        if (circle.isSelected){drawBoundaryBox(circle);}
    }


    public void drawOval(XOval oval) {
        gc.setFill(oval.getColor());
        gc.fillOval(oval.x_coord, oval.y_coord, oval.getWidth(), oval.getHeight());
        if (oval.isSelected){drawBoundaryBox(oval);}
    }

    public void drawSquare(XSquare square) {
        gc.setFill(square.getColor());
        gc.fillRect(square.x_coord, square.y_coord, square.getWidth(), square.getHeight());
        if (square.isSelected){drawBoundaryBox(square);}
    }

    public void drawRect(XRectangle rect) {
        gc.setFill(rect.getColor());
        gc.fillRect(rect.x_coord, rect.y_coord, rect.getWidth(), rect.getHeight());
        if (rect.isSelected){drawBoundaryBox(rect);}
    }

    public void drawLine(XLine line) {
        gc.setLineDashes(0);
        gc.setStroke(line.getColor());
        gc.strokeLine(line.x_coord, line.y_coord, line.getWidth(), line.getHeight());
    }

    public void drawBoundaryBox(XShape shape){
        gc.setLineDashes(4d);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(shape.x_coord, shape.y_coord, shape.x_coord+shape.getWidth(), shape.y_coord);
        gc.strokeLine(shape.x_coord, shape.y_coord, shape.x_coord, shape.y_coord+shape.getHeight());
        gc.strokeLine(shape.x_coord+shape.getWidth(), shape.y_coord, shape.x_coord+shape.getWidth(), shape.y_coord+shape.getHeight());
        gc.strokeLine(shape.x_coord, shape.y_coord+shape.getHeight(), shape.x_coord+shape.getWidth(), shape.y_coord+shape.getHeight());
        drawHandle(shape);
    }

    public void drawHandle(XShape shape){
        gc.setFill(Color.BLACK);
        gc.fillOval(shape.x_coord+shape.getWidth()-3, shape.y_coord+shape.getHeight()-3, 12, 12);
    }

    public void modelChanged() {
        draw();
    }
}
