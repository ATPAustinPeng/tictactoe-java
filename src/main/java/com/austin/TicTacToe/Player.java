package com.austin.TicTacToe;

import java.util.Scanner;

public class Player {

    /**
     * The char that the player uses to play its moves on the board.
     */
    private char key;

    /**
     * Default constructor: creates a player object with a default key 'O'.
     * @param key
     */
    public Player() {
        this.key = 'O';
    }

    /**
     * Creates a player object with the key 'X'
     * @param char key
     */
    public Player(char key) {
        this.key = key;
    }

    /**
     * Gets the key used by the player
     * @return the key used by the player
     */
    public char getKey() {
        return key;
    }

    /**
     * The player makes their move.
     * @param board the current state of the board
     */
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
