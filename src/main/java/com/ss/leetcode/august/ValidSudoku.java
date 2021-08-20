package com.ss.leetcode.august;

public class ValidSudoku {
    // https://leetcode.com/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && (!(validCell(i, j, board) && validLine(i, j, board) && validColumn(i, j, board)))) {
                        return false;
                }
            }
        }
        return true;
    }

    private boolean validCell(int rowIndex, int colIndex, char[][] board) {
        int startRow = rowIndex - rowIndex % 3;
        int startColumn = colIndex - colIndex % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == board[rowIndex][colIndex] && (i != rowIndex || j != colIndex)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validLine(int rowIndex, int colIndex, char[][] board) {
        // verify left segment
        for (int j = 0; j < colIndex - colIndex % 3; j++) {
            if (board[rowIndex][j] == board[rowIndex][colIndex] && (j != colIndex)) {
                return false;
            }
        }
        // verify right segment
        for (int j = (colIndex - colIndex % 3) + 3; j < board[rowIndex].length; j++) {
            if (board[rowIndex][j] == board[rowIndex][colIndex] && (j != colIndex)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(int rowIndex, int colIndex, char[][] board) {
        // verify upper segment
        for (int i = 0; i < rowIndex - rowIndex % 3; i++) {
            if (board[i][colIndex] == board[rowIndex][colIndex] && (i != rowIndex)) {
                return false;
            }
        }
        // verify lower segment
        for (int i = (rowIndex - rowIndex % 3) + 3; i < board.length; i++) {
            if (board[i][colIndex] == board[rowIndex][colIndex] && (i != rowIndex)) {
                return false;
            }
        }
        return true;
    }
}
