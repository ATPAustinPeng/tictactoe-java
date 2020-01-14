package com.austin.TicTacToe;

import java.util.Scanner;

public class Player {
    private char key;

    public Player(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public void move(Board board) {
        Scanner console = new Scanner(System.in);
        int x = console.nextInt();
        int y = console.nextInt();

        while(true) {
            if (board.isValidMove(x, y)) {
                board.getBoard()[x][y] = getKey();
                break;
            }
            else {
                System.out.println("Invalid Move. Enter another move...");
                x = console.nextInt();
                y = console.nextInt();
            }
        }
    }
}
