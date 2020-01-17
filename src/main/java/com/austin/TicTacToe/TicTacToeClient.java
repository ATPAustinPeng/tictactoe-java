package com.austin.TicTacToe;

public class TicTacToeClient {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();

        AI ai = new AI();
        Player player = new Player();

        System.out.println("The game of Tic-Tac-Toe has now begun...");

        int counter = 0;
        while(board.checkWinner() == ' ') {
            if (counter % 2 == 0) {
                System.out.println("AI's turn...");
                System.out.println("Thinking of what move to make...");
                Thread.sleep(1000);
                ai.move(board);
            }
            else {
                System.out.println("Player's turn...");
                player.move(board);
            }

            counter++;
            System.out.println(board.printBoard());

            if (board.checkWinner() == 'X') {
                System.out.println("AI won!");
            }
            else if (board.checkWinner() == 'O') {
                System.out.println("Player won!");
            }
            else if (board.checkWinner() == 'T') {
                System.out.println("Tie Game!");
            }
        }
    }
}