package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.List;


public class SudokuSolver2 {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] cells = new boolean[9][10];
        List<int[]> solutions = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int cellIndex = 3 * (i / 3) + j / 3;
                if (board[i][j] == '.') {
                    solutions.add(new int[] { i, j });
                } else {
                    int digitValue = board[i][j] - '0';
                    rows[i][digitValue] = true;
                    columns[j][digitValue] = true;
                    cells[cellIndex][digitValue] = true;
                }

            }
        }
        searchSolution(solutions, 0, board, rows, columns, cells);
    }

    public boolean searchSolution(List<int[]> solutions, int solutionIndex, char[][] board,
                                  boolean[][] rows, boolean[][] columns, boolean[][] cells) {
        if (solutions.size() <= solutionIndex) {
            return true;
        }

        int rowIndex = solutions.get(solutionIndex)[0];
        int colIndex = solutions.get(solutionIndex)[1];

        int cellIndex = 3 * (rowIndex / 3) + colIndex / 3;

        for (int i = 1; i < 10; i++) {
            board[rowIndex][colIndex] = (char) (i + '0');
            if (!(rows[rowIndex][i] || columns[colIndex][i] || cells[cellIndex][i])) {
                rows[rowIndex][i] = true;
                columns[colIndex][i] = true;
                cells[cellIndex][i] = true;

                if (searchSolution(solutions, solutionIndex + 1, board, rows, columns, cells)) {
                    return true;
                } else {
                    rows[rowIndex][i] = false;
                    columns[colIndex][i] = false;
                    cells[cellIndex][i] = false;
                }
            }
        }
        return false;
    }
}