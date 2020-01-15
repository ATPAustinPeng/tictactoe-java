package com.austin.TicTacToe;

import java.util.Scanner;


// TODO : found a problem with the minimax algorithm when user plays 1,0 and then 1,1. ai doesn't win. by playing 0,1
public class TicTacToeClient {
    public static void main(String[] args) {
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
}