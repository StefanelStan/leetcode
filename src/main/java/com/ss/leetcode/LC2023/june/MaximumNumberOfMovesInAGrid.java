package com.ss.leetcode.LC2023.june;

public class MaximumNumberOfMovesInAGrid {
    // https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
    public int maxMoves(int[][] grid) {
        int[][] moves = getMoves(grid);
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, moves[i][0]);
        }
        return max;
    }

    private int[][] getMoves(int[][] grid) {
        int[][] moves = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                setNumberOfMoves(grid, moves, i, j);
            }
        }
        return moves;
    }

    private void setNumberOfMoves(int[][] grid, int[][] moves, int row, int col) {
        for (int i = Math.max(0, row-1); i <= Math.min(row+1, grid.length-1); i++) {
            if(grid[i][col+1] > grid[row][col]) {
                moves[row][col] =  Math.max(moves[row][col], moves[i][col+1] + 1);
            }
        }
    }
}
