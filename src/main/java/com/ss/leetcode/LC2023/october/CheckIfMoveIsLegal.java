package com.ss.leetcode.LC2023.october;

public class CheckIfMoveIsLegal {
    // https://leetcode.com/problems/check-if-move-is-legal
    /** Algorithm
        1. Traverse the matrix in all 8 directions and check if you have a good line.
        2. Traversing: from the given point you can advance x/y via directions: up(x-1 and y+0), down(x+1, y+0),
            left:(x+0, y-1), top right: (x_1, y+1).
        3. While traversing each direction, if current cell is blank/empty, return false immediately.
        4. Else, count the colors. When your same color is == 2, then your opposite color MUST BE > 0 in order for line to be
     */
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int rows = board.length, columns = board[0].length;
        return isGoodMove(board, rMove, cMove, color, -1, -1, 0, -1)
            || isGoodMove(board, rMove, cMove, color, -1, -1, 1, columns)
            || isGoodMove(board, rMove, cMove, color, 0, rows, 1, columns)
            || isGoodMove(board, rMove, cMove, color, 1, rows, 1, columns)
            || isGoodMove(board, rMove, cMove, color, 1, rows, 0, columns)
            || isGoodMove(board, rMove, cMove, color, 1, rows, -1, -1)
            || isGoodMove(board, rMove, cMove, color, 0, rows, -1, -1)
            || isGoodMove(board, rMove, cMove, color, -1, -1, -1, -1);
    }

    private boolean isGoodMove(char[][] board, int rMove, int cMove, char color, int rowDirection, int rowLimit, int colDirection, int colLimit) {
        int sameColorCount = 1, oppositeColor = 0;
        while ((rMove += rowDirection) != rowLimit && (cMove += colDirection) != colLimit) {
            if (board[rMove][cMove] == '.') {
                return false;
            } else if (board[rMove][cMove] == color) {
                sameColorCount++;
            } else {
                oppositeColor++;
            }
            if (sameColorCount >= 2) {
                return oppositeColor > 0;
            }
        }
        return false;
    }
}
