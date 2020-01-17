package com.austin.TicTacToe;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Scanner;

public class GUI extends Application {

    private static final int SCENE_WIDTH = 900;
    private static final int SCENE_HEIGHT = 900;

    public static void main(String[] args) {
        // launch is a method in Application that runs the start method (overridden below)
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI");

        Group layout = new Group();
        Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);


        primaryStage.show();

    }
}
