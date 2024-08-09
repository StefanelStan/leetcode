package com.ss.leetcode.LC2022.march;

public class MagicSquaresInGrid {
    // https://leetcode.com/problems/magic-squares-in-grid/
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                count += isMagicSquare(grid, i, j) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {
        boolean[] present = new boolean[10];
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[x + i][y + j] == 0 || grid[x + i][y + j] > 9 || present[grid[x + i][y + j]]) {
                    return false;
                }
                present[grid[x + i][y + j]] = true;
                rowSum[i] += grid[x + i][y + j];
                colSum[j] += grid[x + i][y + j];
            }
        }
        return rowSum[0] == rowSum[1] && rowSum[0] == rowSum[2]
            && rowSum[0] == colSum[0] && rowSum[0] == colSum[1] && rowSum[0] == colSum[2]
            && rowSum[0] == (grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2])
            && rowSum[0] == (grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y]);
    }

    public int numMagicSquaresInside2(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int magicSquares = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    magicSquares++;
                }
            }
        }
        return magicSquares;
    }

    private boolean isMagicSquare2(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int tempSum = 0;
        // row sum
        for (int i = row; i <= row + 2; i++) {
            tempSum = 0;
            for (int j = col; j <= col + 2; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1 || seen[grid[i][j]]) {
                    return false;
                }
                seen[grid[i][j]] = true;
                tempSum += grid[i][j];
            }
            if (tempSum != sum) {
                return false;
            }
        }
        //col sum
        for (int j = col; j <= col + 2; j++) {
            if (grid[row][j] + grid[row + 1][j] + grid[row + 2][j] != sum) {
                return false;
            }
        }
        //diag 1 and 2
        return grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum &&
            grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum;
    }
}
