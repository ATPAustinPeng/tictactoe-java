package com.austin.TicTacToe;

public class Board {

    private char[][] board;

    public Board() {
        this.board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    /**
     * Returns the winner. (X, O, ' ')
     * @return the winner (X, O); returns a space (' ') if there is no winner
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

    public int numEmptySpots() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Finds the winner and sets the winner.
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
