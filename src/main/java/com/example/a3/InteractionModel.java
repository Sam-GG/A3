package com.example.a3;

import java.util.ArrayList;

public class InteractionModel {
    ArrayList<InteractionModelSubscriber> subscribers;
    double viewWidth, viewHeight;

    public InteractionModel() {
        subscribers = new ArrayList<>();
    }

    public void setViewSize(double width, double height) {
        viewWidth = width;
        viewHeight = height;
    }

    public double getViewWidth() {
        return viewWidth;
    }
    public double getViewHeight() {
        return viewHeight;
    }
}
