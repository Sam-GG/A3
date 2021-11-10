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

    public void setModel(DrawingModel newModel) {
        this.model = newModel;
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
        iModel.setViewSize(myCanvas.getWidth(), myCanvas.getHeight());
    }

    public void setController(DrawingController controller) {
        myCanvas.setOnMousePressed(controller::handlePressed);
//        myCanvas.setOnMouseDragged(controller::handlePressed);
    }

    public DrawingView(){
        myCanvas = new Canvas(500, 500);
        gc = myCanvas.getGraphicsContext2D();
        this.getChildren().add(myCanvas);
    }

    public void draw(){
        //Setting up canvas
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(gc.getCanvas().getLayoutX(),
                gc.getCanvas().getLayoutY(),
                gc.getCanvas().getWidth(),
                gc.getCanvas().getHeight());

        model.getItems().forEach(item -> {
            switch (item) {
                case XCircle circle -> this.drawCircle(circle);
                case XSquare square -> this.drawSquare(square);
                case XRectangle rect -> this.drawRect(rect);
                case XOval oval -> this.drawOval(oval);
                case XLine line -> this.drawLine(line);
                default -> throw new IllegalStateException("Unexpected value: " + item);
            }
        });
    }
    private void drawCircle(XCircle circle) {
        gc.setFill(circle.getColor());
        gc.fillOval(circle.x_coord, circle.y_coord, circle.getSize(), circle.getSize());
    }

    private void drawOval(XOval oval) {
        gc.setFill(oval.getColor());
        gc.fillOval(oval.x_coord, oval.y_coord, oval.getSize(), oval.getHeight());
    }

    private void drawSquare(XSquare square) {
        gc.setFill(square.getColor());
        gc.fillRect(square.x_coord, square.y_coord, square.getSize(), square.getSize());
    }

    private void drawRect(XRectangle rect) {
        gc.setFill(rect.getColor());
        gc.fillRect(rect.x_coord, rect.y_coord, rect.getSize(), rect.getHeight());
    }

    private void drawLine(XLine line) {
        gc.setFill(line.getColor());
        gc.fillRect(line.x_coord, line.y_coord, line.getSize(), 3);
    }

    public void modelChanged() {
        draw();
    }
}
