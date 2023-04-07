package com.ss.leetcode.LC2023.april;

public class NumberOfEnclaves {
    // https://leetcode.com/problems/number-of-enclaves
    /** Algorithm
        1. All 1s that sit on the border will cause any connected 1s to be "bad land" cells, so they need to be eliminated.
        2. Start from the 4 edges and mark all 1 cells with 0. Use a recursive function that will continue to mark them with 0 if they are 1.
        3. Once this is done, your board will contain only those 1s that are now edged/cornered by 0s that block the edges.
        4. Count and return all the 1s that remain on the board.
     */
    public int numEnclaves(int[][] grid) {
        markBadOnes(grid);
        return countOnes(grid);
    }

    private void markBadOnes(int[][] grid) {
        markHorizontally(0, grid);
        markHorizontally(grid.length -1, grid);
        markVertically(0, grid);
        markVertically(grid[0].length -1, grid);
    }

    private void markHorizontally(int row, int[][] grid) {
        for (int j = 0; j < grid[row].length; j++) {
            if (grid[row][j] == 1) {
                markBadCells(row, j, grid);
            }
        }
    }

    private void markVertically(int col, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                markBadCells(i, col, grid);
            }
        }
    }

    private void markBadCells(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        markBadCells(i-1, j, grid);
        markBadCells(i, j+1, grid);
        markBadCells(i+1, j, grid);
        markBadCells(i, j-1, grid);
    }

    private int countOnes(int[][] grid) {
        int ones = 0;
        for (int[] row : grid) {
            for (int element : row) {
                ones += element;
            }
        }
        return ones;
    }
}
