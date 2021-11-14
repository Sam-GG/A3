package com.example.a3;

import javafx.scene.paint.Color;

import java.util.*;

public class DrawingModel {
    private ArrayList<XShape> items;
    private ArrayList<DrawingModelSubscriber> subs;
    private Color currentColor = Color.AQUA;
    private String currentShapeType;

    public DrawingModel() {
        items = new ArrayList<>();
        subs = new ArrayList<>();
    }

    public void addSubscriber(DrawingModelSubscriber aSub) {
        subs.add(aSub);
    }

    private void notifySubscribers() {
        subs.forEach(sub -> sub.modelChanged());
    }

    public void addCircle(int width, int height, int x_coord, int y_coord) {
        items.add(new XCircle(currentColor, width, height, x_coord, y_coord));
        updateSelected();
        notifySubscribers();
    }

    public void addSquare(int width, int height, int x_coord, int y_coord) {
        items.add(new XSquare(currentColor, width, height, x_coord, y_coord));
        updateSelected();
        notifySubscribers();
    }

    public void addRect(int width, int height, int x_coord, int y_coord) {
        items.add(new XRectangle(currentColor, width, height, x_coord, y_coord));
        updateSelected();
        notifySubscribers();
    }

    public void addOval(int width, int height, int x_coord, int y_coord) {
        items.add(new XOval(currentColor, width, height, x_coord, y_coord));
        updateSelected();
        notifySubscribers();
    }

    public void addLine(int width, int height, int x_coord, int y_coord) {
        items.add(new XLine(currentColor, width, height, x_coord, y_coord));
        updateSelected();
        notifySubscribers();
    }

    public List<XShape> getItems() {
        return items;
    }

    public void setCurrentColor(Color c){
        this.currentColor = c;
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public void setCurrentShapeDrag(int dragStartX, int dragStartY, int x, int y, boolean xFlipped, boolean yFlipped){
        int width = Math.abs(x - dragStartX);
        int height = Math.abs(y - dragStartY);
        switch (getSelectedShape()) {
            case XRectangle rect -> {rect.setHeight(height);
                rect.setWidth(width);
                if (xFlipped){
                    rect.x_coord = (int)x;
                }
                if(yFlipped){
                    rect.y_coord = (int)y;
                }
            }
            case XOval oval -> {oval.setHeight(height);
                oval.setWidth(width);
                if (xFlipped){
                    oval.x_coord = (int)x;
                }
                if(yFlipped){
                    oval.y_coord = (int)y;
                }}
            case XCircle circle -> {
                int min = Math.min(height, width);
                circle.setWidth(min);
                circle.setHeight(min);
                if (min == height){
                    if(yFlipped){
                        circle.y_coord = dragStartY-height;
                    }
                    if (xFlipped){
                        circle.x_coord = dragStartX-height;
                    }
                }else if(min == width){
                    if(yFlipped){
                        circle.y_coord = dragStartY-width;
                    }
                    if (xFlipped){
                        circle.x_coord = dragStartX-width;
                    }
                }
            }
            case XSquare square -> {
                int min = Math.min(height, width);
                square.setWidth(min);
                square.setHeight(min);
                if (min == height){
                    if(yFlipped){
                        square.y_coord = dragStartY-height;
                    }
                    if (xFlipped){
                        square.x_coord = dragStartX-height;
                    }
                }else if(min == width){
                    if(yFlipped){
                        square.y_coord = dragStartY-width;
                    }
                    if (xFlipped){
                        square.x_coord = dragStartX-width;
                    }
                }
            }
            case XLine line -> {
                line.setWidth(x);
                line.setHeight(y);
            }

            default -> throw new IllegalStateException("Unexpected value: " + items.get(items.size() - 1));
        }
        notifySubscribers();
    }

    public void moveShape(int x, int y, int dragStartX, int dragStartY){
        getSelectedShape().x_coord = x;
        getSelectedShape().y_coord = y;
        notifySubscribers();
    }

    public XShape getSelectedShape(){
        return items.get(items.size()-1);
    }

    public void updateSelected(){
        items.forEach(item -> item.isSelected = false);
        getSelectedShape().isSelected = true;
    }

    public void deselect(){
        if (getSelectedShape().getWidth() == 1 && getSelectedShape().getHeight() == 1){
            items.remove(items.remove(items.size()-1));
        }
        notifySubscribers();
    }

    public boolean grabbedResizeHandle(double x, double y){
        if (!items.isEmpty() && getSelectedShape().isSelected) {
            int grabAreaX = getSelectedShape().x_coord + getSelectedShape().getWidth();
            int grabAreaY = getSelectedShape().y_coord + getSelectedShape().getHeight();
            if ((int)x >= grabAreaX && (int)x < grabAreaX+15){
                if ((int)y >= grabAreaY && (int)y < grabAreaY+15){
                    return true;
                }
            }
        }
        return false;
    }

    public Optional<XShape> getItem(int x, int y) {
        return items.stream().filter(item -> item.contains(x,y)).findFirst();
    }

    public void bringShapeToFront(XShape xShape) {
        int idx = this.items.indexOf(xShape);
        Collections.rotate(this.items.subList(idx, items.size()), -1);
        updateSelected();
        notifySubscribers();
    }

    public void removeSelectedShape(){
        if (getSelectedShape().isSelected){
            items.remove(items.size()-1);
            notifySubscribers();
        }
    }
}
