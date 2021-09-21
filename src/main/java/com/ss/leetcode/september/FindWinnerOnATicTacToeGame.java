package com.ss.leetcode.september;

public class FindWinnerOnATicTacToeGame {
    // https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
    public String tictactoe(int[][] moves) {
        char[][] board = getBoard(moves);
        return getWinner(board, moves.length);
    }

    private char[][] getBoard(int[][] moves) {
        char[][] board = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
        int turns = moves.length;
        for (int i = 0; i < (turns % 2 ==  0 ? turns -1 :  turns -2); i += 2) {
            board[moves[i][0]][moves[i][1]] = 'A';
            board[moves[i + 1][0]][moves[i + 1][1]] = 'B';
        }
        if (moves.length % 2 == 1) {
            board[moves[turns -1][0]][moves[turns-1][1]] = 'A';
        }
        return board;
    }

    private String getWinner(char[][] board, int turns) {
        for (char[] line : board) {
            if ((line[0] == 'A' || line[0] == 'B') && line[0] == line[1] && line[1] == line[2]) {
                return String.valueOf(line[0]);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if ((board[0][j] == 'A' || board[0][j] == 'B') && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return String.valueOf(board[0][j]);
            }
        }
        if ((board[0][0] == 'A' || board[0][0] == 'B') && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return String.valueOf(board[0][0]);
        }
        if ((board[2][0] == 'A' || board[2][0] == 'B') && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return String.valueOf(board[2][0]);
        }
        return turns == 9 ? "Draw" : "Pending";
    }
}
