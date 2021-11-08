package com.example.a3;

public class XShape {
    private int size;
    public int x_coord;
    public int y_coord;

    public XShape(int size, int x_coord, int y_coord){
        this.size = size;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public int getSize(){
        return this.size;
    }
}
