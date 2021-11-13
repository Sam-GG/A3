package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

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
//        myCanvas.setOnMouseDragReleased(controller::handlePressed);
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
                case XRectangle rect -> this.drawRect(rect);
                case XOval oval -> this.drawOval(oval);
                case XLine line -> this.drawLine(line);
                default -> throw new IllegalStateException("Unexpected value: " + item);
            }
        });
    }

//    double showX1 = 10;
//    double showY1 = 10;
//`
//    public void drawResize(double scaleFactor, double x_coord, double y_coord){
//        scaleFactor+=1;
//        showX1 *= scaleFactor;
//        showY1 *= scaleFactor;
//
//        gc.setFill(Color.RED);
//        gc.fillRect(x_coord,y_coord, showX1,showY1);
//    }
//    private void getNormalized

    public void drawCircle(XCircle circle) {
//        double drawCoefficientX = gc.getCanvas().getWidth()/(double)500;
//        double drawCoefficientY = gc.getCanvas().getHeight()/(double)500;
//        System.out.println(drawCoefficientX);
        gc.setFill(circle.getColor());
        gc.fillOval(circle.x_coord, circle.y_coord, circle.getWidth(), circle.getHeight());
    }


    public void drawOval(XOval oval) {
        gc.setFill(oval.getColor());
        gc.fillOval(oval.x_coord, oval.y_coord, oval.getWidth(), oval.getHeight());

//        gc.fillOval((double)oval.x_coord/5, (double)oval.y_coord/5, (double)oval.getSize()/5, (double)oval.getHeight()/5);
    }

    public void drawSquare(XSquare square) {
        gc.setFill(square.getColor());
        gc.fillRect(square.x_coord, square.y_coord, square.getWidth(), square.getHeight());
    }

    public void drawRect(XRectangle rect) {
        gc.setFill(rect.getColor());
        gc.fillRect(rect.x_coord, rect.y_coord, rect.getWidth(), rect.getHeight());
    }

    public void drawLine(XLine line) {
//        gc.setFill(line.getColor());
        gc.setStroke(line.getColor());
        gc.strokeLine(line.x_coord, line.y_coord, line.getWidth(), line.getHeight());
    }

    public void modelChanged() {
        draw();
    }
}
