package com.example.a3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DrawingModel model = new DrawingModel();
        DrawingView view = new DrawingView();
        DrawingController controller = new DrawingController();
        InteractionModel iModel = new InteractionModel();
        ShapeToolbar shapeToolbar = new ShapeToolbar();

        model.addSubscriber(view);
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