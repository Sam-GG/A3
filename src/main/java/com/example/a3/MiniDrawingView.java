package com.example.a3;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class MiniDrawingView extends DrawingView implements DrawingModelSubscriber{
    Boolean isMini;

    public MiniDrawingView(int width, int height){
        super(width, height);
        this.isMini = true;
        myCanvas = new Canvas(width, height);
        gc = myCanvas.getGraphicsContext2D();
        this.getChildren().add(myCanvas);
        this.gc.setFill(Color.LIGHTGRAY);
        this.gc.fillRect(gc.getCanvas().getLayoutX(),
                this.gc.getCanvas().getLayoutY(),
                this.gc.getCanvas().getWidth(),
                this.gc.getCanvas().getHeight());
        System.out.println(width);
    }

    public void setInteractionModel(InteractionModel newIModel) {
        iModel = newIModel;
//        iModel.setViewSize(myCanvas.getWidth(), myCanvas.getHeight());
    }
//    @Override
//    public void drawOval(XOval oval) {
//        gc.setFill(oval.getColor());
////        gc.fillOval((double)oval.x_coord/5, (double)oval.y_coord/5, (double)oval.getSize()/5, (double)oval.getHeight()/5);
//        gc.fillOval(oval.x_coord/5, oval.y_coord/5, (double)oval.getSize()/5, (double)oval.getHeight()/5);
////        gc.fillOval(oval.x_coord*5, oval.y_coord*5, oval.getSize(), oval.getHeight());
//    }
//
//    public void draw() {
//        System.out.println(this.gc.getCanvas().getWidth());
//        this.gc.setFill(Color.LIGHTGRAY);
//        this.gc.fillRect(gc.getCanvas().getLayoutX(),
//                this.gc.getCanvas().getLayoutY(),
//                this.gc.getCanvas().getWidth(),
//                this.gc.getCanvas().getHeight());
//        model.getItems().forEach(item -> {
//            switch (item) {
//                case XCircle circle -> this.drawCircle(circle);
//                case XSquare square -> this.drawSquare(square);
//                case XRectangle rect -> this.drawRect(rect);
//                case XOval oval -> this.drawOval(oval);
//                case XLine line -> this.drawLine(line);
//                default -> throw new IllegalStateException("Unexpected value: " + item);
//            }
//        });
//    }
}
