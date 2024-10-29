package com.ss.leetcode.LC2023.june;

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {
    // https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
    /** Algorithm
        1. For each column j [1,n-1] you need to see if you can arrive from the left side
        2. Use an boolean[m] canTravel to keep track of this possibility for each row.
        3. For each column [1,n-1]
            - use a boolean nextTravel[] to keep track of next travel possibility, based on prev travel.
            - for each row [0, m-1]
                - check all 3 indices. If grid[prevRow][prevCol] < grid[i][j], then your new nextTravel[] = false || canTravel[left][left]
                - if no nextTravel is true, then stop travelling. you can't pass the current column.
        4. Return max number of travelled columns.
     */
    public int maxMoves(int[][] grid) {
        int maxTravelledColumns = 0;
        boolean[] canTravel = new boolean[grid.length];
        boolean[] nextTravel;
        Arrays.fill(canTravel, true);
        boolean stillTravelling = true;
        for (int j = 1; j < grid[0].length && stillTravelling; j++) {
            nextTravel = new boolean[grid.length];
            stillTravelling = false;
            for (int i = 0; i < grid.length; i++) {
                nextTravel[i] = canTravelFrom(i, j, grid, canTravel);
                stillTravelling = stillTravelling || nextTravel[i];
            }
            canTravel = nextTravel;
            maxTravelledColumns += stillTravelling ? 1 : 0;

        }
        return maxTravelledColumns;
    }

    private boolean canTravelFrom(int i, int j, int[][] grid, boolean[] canTravel) {
        boolean answer = false;
        if (i < grid.length - 1 && j > 0 && grid[i + 1][j - 1] < grid[i][j]) {
            answer = canTravel[i + 1];
        }
        if (j > 0 && grid[i][j-1] < grid[i][j]) {
            answer = answer || canTravel[i];
        }
        if (i > 0 && j > 0 && grid[i-1][j-1] < grid[i][j]) {
            answer =  answer || canTravel[i-1];
        }
        return answer;
    }

    public int maxMoves2(int[][] grid) {
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
