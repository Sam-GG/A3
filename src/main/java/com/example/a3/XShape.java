package com.example.a3;

import javafx.scene.paint.Color;

public class XShape {
    private int width;
    private int height;
    private Color color;
    public int x_coord;
    public int y_coord;

    public XShape(Color color, int width, int height, int x_coord, int y_coord){
        this.color = color;
        this.width = width;
        this.height = height;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return this.color;
    }
}
