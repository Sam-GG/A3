package com.example.a3;

import javafx.scene.paint.Color;

public class XShape {
    private int size;
    private Color color;
    public int x_coord;
    public int y_coord;

    public XShape(Color color, int size, int x_coord, int y_coord){
        this.color = color;
        this.size = size;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public int getSize(){
        return this.size;
    }

    public Color getColor() {
        return this.color;
    }
}
