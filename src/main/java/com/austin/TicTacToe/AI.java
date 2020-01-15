package com.austin.TicTacToe;


// Assuming AI goes first...
public class AI {

    private char key;

    public AI(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public void move(Board board) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoard()[i][j] == ' ') {
                    board.getBoard()[i][j] = getKey();
                    int score = minimax(board, 0 , false);
                    board.getBoard()[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                    board.getBoard()[i][j] = ' ';
                }
            }
        }
        board.getBoard()[bestMove[0]][bestMove[1]] = getKey();
    }

    // if moving first, set isMaximizing for the first call as TRUE
    public int minimax(Board board, int depth, boolean isMaximizing) {
        char winner = board.checkWinner();
        if (winner == getKey()) {
            return 1;
        } else if (winner == 'O') {
            return -1;
        } else if (winner == 'T') {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // if spot is open
                    if (board.getBoard()[i][j] == ' ') {
                        board.getBoard()[i][j] = getKey();
                        int score = minimax(board, depth + 1, false);
                        board.getBoard()[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getBoard()[i][j] == ' ') {
                        board.getBoard()[i][j] = 'O';
                        int score = minimax(board, depth + 1, true);
                        board.getBoard()[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
