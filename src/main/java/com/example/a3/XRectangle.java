package com.example.a3;

import javafx.scene.paint.Color;

public class XRectangle extends XShape{
    private int height;
    public XRectangle(Color color, int size, int height, int x_coord, int y_coord) {
        super(color, size, x_coord, y_coord);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }
}
