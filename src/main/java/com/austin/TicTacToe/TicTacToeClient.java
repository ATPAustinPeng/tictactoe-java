package com.austin.TicTacToe;

import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Board board = new Board();
//        Player x = new Player('X');
        AI ai = new AI('X');
        Player player = new Player('O');

        System.out.println(board.toString());

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
            System.out.println(board.toString());

            if (board.checkWinner() == 'X' || board.checkWinner() == 'O') {
                System.out.println("Player " + board.checkWinner() + " won!");
            }
            else if (board.checkWinner() == 'T') {
                System.out.println("Tie Game!");
            }
        }
    }
}