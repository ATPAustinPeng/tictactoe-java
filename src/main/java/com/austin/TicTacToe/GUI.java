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

    private static Group playerMoves = new Group();

    public static void main(String[] args) {
        // launch is a method in Application that runs the start method (overridden below)
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI");

//        Group layout = new Group();
        Scene scene = new Scene(playerMoves, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);


//        Button button = new Button();
//        button.setText("Click me...");
//        layout.getChildren().add(button);

        primaryStage.show();

        playTicTacToe();

    }

    public static void playTicTacToe() {
        Scanner console = new Scanner(System.in);

        Board board = new Board();
//        Player x = new Player('X');
        AI ai = new AI('X');
        Player player = new Player('O');

        System.out.println(board.printBoard());

        int counter = 0;
        while(board.checkWinner() == ' ') {
//            Player toMove = counter % 2 == 0 ? x : o;
//            System.out.println("Player " + toMove.getKey() + " to move!");
            if (counter % 2 == 0) {
                ai.move(board);
            }
            else {
                player.move(board);
            }

            counter++;
            System.out.println(board.printBoard());

            if (board.checkWinner() == 'X' || board.checkWinner() == 'O') {
                System.out.println("Player " + board.checkWinner() + " won!");
            }
            else if (board.checkWinner() == 'T') {
                System.out.println("Tie Game!");
            }
        }
    }


    public static void drawLine(int startX, int startY, int endX, int endY) {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);

        playerMoves.getChildren().add(line);
    }

    public static void displayBoard(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char key = board.getBoard()[i][j];
                if (key == ' ') {
                    continue;
                }
                else if (key == 'X') {
                    drawLine(i * SCENE_WIDTH / 3, j * SCENE_HEIGHT / 3, (i + 1) * SCENE_WIDTH / 3, (j + 1) * SCENE_HEIGHT / 3);

                }
                else if (key == 'O') {
                    // TODO : IMPLEMENT
                    continue;
                }
                else {
                    continue;
                }
            }
        }

    }



}
