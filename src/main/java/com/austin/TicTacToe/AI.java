package com.austin.TicTacToe;


// NOTE: definitely not an AI... this is just an algorithm...
public class AI {

    /**
     * The char that the 'AI' uses to play its moves on the board.
     */
    private char key;

    /**
     * Constructs a AI object with a default key 'X'.
     */
    public AI() {
        this.key = 'X';
    }

    /**
     * Gets the key used by the AI
     * @return the key used by the AI
     */
    public char getKey() {
        return key;
    }

    /**
     * AI finds its next move (using the minimax algorithm).
     * @param board the current board state
     */
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

    /**
     * A helper method to aid the AI in finding the best possible move through using the minimax algorithm.
     * AI is trying to maximize its score in order to find its best move to help it win.
     * AI also calculates the best move for the player (minimizing) in order to maximize its further/next moves.
     * @param board the current board state
     * @param depth the depth of the recursive call (mainly for debugging purposes)
     * @param isMaximizing whether or not the AI or player is moving (if AI is moving, it is trying to maximize; if player is moving, it is trying to minimize)
     * @return the best score; 1 if AI wins, 0 if tie, -1 if player wins
     */
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
