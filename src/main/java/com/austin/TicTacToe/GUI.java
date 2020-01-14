package com.austin.TicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        // launch is a method in Application that runs the start method (overridden below)
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 900, 900);
        primaryStage.setScene(scene);

        Button button = new Button();
        button.setText("Click me...");


        layout.getChildren().add(button);


        primaryStage.show();

    }


}
