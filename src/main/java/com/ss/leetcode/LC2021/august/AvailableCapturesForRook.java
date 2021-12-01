package com.ss.leetcode.LC2021.august;

public class AvailableCapturesForRook {
    // https://leetcode.com/problems/available-captures-for-rook/
    public int numRookCaptures(char[][] board) {
        int rookCaptures = 0;
        int[] rook = getRookPosition(board);
        rookCaptures += getLeftCaptures(rook, board);
        rookCaptures += getRightCaptures(rook, board);
        rookCaptures += getUpperCaptures(rook, board);
        rookCaptures += getLowerCaptures(rook, board);
        return rookCaptures;
    }

    private int[] getRookPosition(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private int getLeftCaptures(int[] rook, char[][] board) {
        for (int j = rook[1] -1; j >= 0; j--) {
            switch(board[rook[0]][j]) {
                case 'p' : return 1;
                case 'B' : return 0;
                default:
            }
        }
        return 0;
    }

    private int getRightCaptures(int[] rook, char[][] board) {
        for (int j = rook[1] + 1; j < board[rook[0]].length; j++) {
            switch(board[rook[0]][j]) {
                case 'p' : return 1;
                case 'B' : return 0;
                default:
            }
        }
        return 0;
    }

    private int getUpperCaptures(int[] rook, char[][] board) {
        for (int i = rook[0] - 1; i >= 0; i--) {
            switch(board[i][rook[1]]) {
                case 'p' : return 1;
                case 'B' : return 0;
                default:
            }
        }
        return 0;
    }

    private int getLowerCaptures(int[] rook, char[][] board) {
        for (int i = rook[0] + 1; i < board.length; i++) {
            switch(board[i][rook[1]]) {
                case 'p' : return 1;
                case 'B' : return 0;
                default:
            }
        }
        return 0;
    }
}
