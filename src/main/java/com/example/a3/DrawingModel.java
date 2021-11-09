package com.example.a3;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
    private ArrayList<XShape> items;
    private ArrayList<DrawingModelSubscriber> subs;
    private Color currentColor = Color.AQUA;
    private XShape currentShape;

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

    public void addCircle(Color color, int size, int x_coord, int y_coord) {
        items.add(new XCircle(color, size, x_coord, y_coord));
        notifySubscribers();
    }

    public void addSquare(Color color, int size, int x_coord, int y_coord) {
        items.add(new XSquare(color, size, x_coord, y_coord));
        notifySubscribers();
    }

    public void addRect(Color color, int size, int height, int x_coord, int y_coord) {
        items.add(new XRectangle(color, size, height, x_coord, y_coord));
        notifySubscribers();
    }

    public void addOval(Color color, int size, int height, int x_coord, int y_coord) {
        items.add(new XOval(color, size, height, x_coord, y_coord));
        notifySubscribers();
    }

    public void addLine(Color color, int size, int x_coord, int y_coord) {
        items.add(new XLine(color, size, x_coord, y_coord));
        notifySubscribers();
    }

    public List<XShape> getItems() {
        return items;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color c){
        this.currentColor = c;
    }
//    public Optional<XShape> getItem(double x, double y) {
//        return items.stream().filter(item -> item.contains(x,y)).findFirst();
//    }
}
