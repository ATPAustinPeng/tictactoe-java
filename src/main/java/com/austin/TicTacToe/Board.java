package com.austin.TicTacToe;

public class Board {

    /**
     * A character array storing the values of the board ('X', 'O', or ' ')
     */
    private char[][] board;

    /**
     * Default constructor: creates a Board object with a 3 by 3 size.
     */
    public Board() {
        this.board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Creates and x (row) by y (column) size board.
     * @param x the number of rows
     * @param y the number of columns
     */
    public Board(int x, int y) {
        this.board = new char[x][y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Gets the board.
     * @return the board (a 2D char array)
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Gets the board state, converts it to a string. Can be printed with System.out.println()
     * @return a String with the current representation of the board
     */
    public String printBoard() {
        String temp = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    temp += board[i][j];
                } else {
                    temp += " | " + board[i][j];
                }
            }
            if (i != board.length - 1) {
                temp += "\n---------\n";
            }
        }
        return temp + "\n";
    }

    /**
     * Tells the player whether or not their move is valid.
     * @param x the x-value of the tic-tac-toe board
     * @param y the y-value of the tic-tac-toe board
     * @return true if the move is valid, false if the move is invalid
     */
    public boolean isValidMove(int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == ' ') {
            return true;
        }
        return false;
    }

    /**
     * Gets the number of empty spots left in the board.
     * @return the number of empty spots in the board
     */
    public int numEmptySpots() {
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }

    // TODO: change this method to be able to check winner for any size board, don't hard code it
    /**
     * Finds the winner, if there is a winner.
     * @return the key of the winner (a char) if there is a winner, 'T' if there is a tie, ' ' if there is no winner
     */
    public char checkWinner() {
        char winner = ' ';
        for (int i = 0; i < board.length; i++) {
            // check horizontal wins
            if (board[i][0] == board[i][1] && board[i][1]== board[i][2] && board[i][0] != ' ') {
                winner = board[i][0];
            }

            // check vertical wins
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[i][0] != ' ') {
                winner = board[0][i];
            }
        }

        // check diagonal wins
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            winner = board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ') {
            winner = board[2][0];
        }

        if (winner == ' ' && numEmptySpots() == 0) {
            winner = 'T';
        }

        return winner;
    }
}
