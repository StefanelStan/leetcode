package com.ss.leetcode.LC2022.april;

public class CountUnguardedCellsInTheGrid {
    // https://leetcode.com/contest/biweekly-contest-77/problems/count-unguarded-cells-in-the-grid/
    private static final char WALL = 'W', GUARD = 'G', SEEN = 'S';
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int unguarded  = 0;
        char[][] matrix = getMatrix(m, n, guards, walls);
        for (int[] guard : guards) {
            guardCells(matrix, guard[0], guard[1]);
        }
        for (char[] row : matrix) {
            for (char cell : row) {
                unguarded += (cell == 0 ? 1 : 0);
            }
        }
        return unguarded;
    }

    private void guardCells(char[][] matrix, int i, int j) {
        for (int c = j + 1; c < matrix[0].length && matrix[i][c] != WALL && matrix[i][c] != GUARD; c++) {
            matrix[i][c] = SEEN;
        }
        for (int c = j - 1; c >= 0 && matrix[i][c] != WALL && matrix[i][c] != GUARD; c--) {
            matrix[i][c] = SEEN;
        }
        for (int r = i - 1; r >= 0 && matrix[r][j] != WALL && matrix[r][j] != GUARD; r--) {
            matrix[r][j] = SEEN;
        }
        for (int r = i + 1; r < matrix.length && matrix[r][j] != WALL && matrix[r][j] != GUARD; r++) {
            matrix[r][j] = SEEN;
        }
    }

    private char[][] getMatrix(int m, int n, int[][] guards, int[][] walls) {
        char[][] matrix = new char[m][n];
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = GUARD;
        }
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = WALL;
        }
        return matrix;
    }


    public int countUnguarded2(int m, int n, int[][] guards, int[][] walls) {
        char[][] cells = new char[m][n];
        for (int[] wall : walls) {
            cells[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            cells[guard[0]][guard[1]] = GUARD;
        }
        for (int[] guard : guards) {
            guardCell(guard, cells);
        }
        int unguarded = 0;
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == 0) {
                    unguarded++;
                }
            }
        }
        return unguarded;
    }

    private void guardCell(int[] guard, char[][] cells) {
        guardRow(guard[0], guard[1] - 1, cells, -1);
        guardRow(guard[0], guard[1] + 1, cells, 1);
        guardColumn(guard[0] - 1, guard[1], cells, -1);
        guardColumn(guard[0] + 1, guard[1], cells, 1);
    }

    private void guardColumn(int row, int col, char[][] cells, int direction) {
        if (row < 0 || row >= cells.length) {
            return;
        }
        for (int i = row; i >= 0 && i < cells.length; i += direction) {
            if (cells[i][col] == WALL || cells[i][col] == GUARD) {
                break;
            } else {
                cells[i][col] = SEEN;
            }
        }
    }

    private void guardRow(int row, int col, char[][] cells, int direction) {
        if (col < 0 || col >= cells[0].length) {
            return;
        }
        for (int j = col; j >= 0 && j < cells[0].length; j += direction) {
            if (cells[row][j] == WALL || cells[row][j] == GUARD) {
                break;
            } else {
                cells[row][j] = SEEN;
            }
        }
    }
}
