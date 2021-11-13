package com.example.a3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DrawingModel model = new DrawingModel();
        DrawingView view = new DrawingView(500, 500);
        DrawingController controller = new DrawingController();
        InteractionModel iModel = new InteractionModel();
        ShapeToolbar shapeToolbar = new ShapeToolbar();
//        MiniDrawingView miniView = new MiniDrawingView(100, 100);

        model.addSubscriber(view);
//        model.addSubscriber(miniView);
        view.setModel(model);
        view.setInteractionModel(iModel);
        view.setController(controller);
        controller.setModel(model);
        controller.setDrawingView(view);
        controller.setInteractionModel(iModel);
        controller.setToggleGroup(shapeToolbar.toggleGroup);
        ColourToolbar colorBar = new ColourToolbar();
        colorBar.setController(controller);
        shapeToolbar.setController(controller);
//        miniView.setModel(model);
//        miniView.setInteractionModel(iModel);
//        miniView.setController(controller);
//        view.getChildren().add(miniView);
//        view.setAlignment(miniView, Pos.TOP_LEFT);


        MainUI mainUI = new MainUI(shapeToolbar, colorBar, view);
        Scene scene = new Scene(mainUI);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}