package com.example.a3;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

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

    public void addCircle(int size, int x_coord, int y_coord) {
        items.add(new XCircle(currentColor, size, x_coord, y_coord));
        notifySubscribers();
    }

    public void addSquare(int size, int x_coord, int y_coord) {
        items.add(new XSquare(currentColor, size, x_coord, y_coord));
        notifySubscribers();
    }

    public void addRect(int size, int height, int x_coord, int y_coord) {
        items.add(new XRectangle(currentColor, size, height, x_coord, y_coord));
        notifySubscribers();
    }

    public void addOval(int size, int height, int x_coord, int y_coord) {
        items.add(new XOval(currentColor, size, height, x_coord, y_coord));
        notifySubscribers();
    }

    public void addLine(int size, int x_coord, int y_coord) {
        items.add(new XLine(currentColor, size, x_coord, y_coord));
        notifySubscribers();
    }

    public List<XShape> getItems() {
        return items;
    }

    public void setCurrentColor(Color c){
        this.currentColor = c;
    }
//    public Optional<XShape> getItem(double x, double y) {
//        return items.stream().filter(item -> item.contains(x,y)).findFirst();
//    }
}
