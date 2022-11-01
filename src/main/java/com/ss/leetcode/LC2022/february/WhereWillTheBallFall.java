package com.ss.leetcode.LC2022.february;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] destinations = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            destinations[j] = getDestination(0, j, grid);
        }
        return destinations;
    }

    private int getDestination(int row, int col, int[][] grid) {
        if(col < 0 || col >= grid[0].length) {
            return -1;
        }
        if (row == grid.length) {
            return col;
        }
        if ((grid[row][col] == 1 && col < grid[0].length - 1 && grid[row][col+1] == -1)
            || (grid[row][col] == -1 && col > 0 && grid[row][col -1] == 1)) {
            return -1;
        }
        return getDestination(row +1, col + grid[row][col], grid);
    }

    /** Algorithm
         1. Determine the final destination for each column(ball) via a method and save it in the answer[]
         2. In this methid, apply a 3 step tactic
         2.1. Treat edge cases of col/ball 0 and LEFT or col == n-1 and RIGHT
         Return -1 in such case
         2.2. For current col check if col-1 or col+1 form a V. If yes, return -1
         2.3. Add current row's sign to col and check if it's < 0 or >= nr_of_columns.
         If yes, return -1
         3. Return the final value of col and save it in answer[].
     */
    public int[] findBall2(int[][] grid) {
        int[] destinations = new int[grid[0].length];
        for (int i = 0; i < destinations.length; i++) {
            destinations[i] = findDestination(i, grid);
        }
        return destinations;
    }

    private int findDestination(int col, int[][] grid) {
        int w = grid[0].length;
        // check edge cases of col = 1 and LEFT or col == length-1 and RIGHT
        //   (driving the ball into the walls)
        if ((col == 0 && grid[0][0] == -1) || (col == w-1 && grid[0][col] == 1)) {
            return -1;
        }
        for (int[] line : grid) {
            // check for V on left or right side, depending on col (L or R)
            if (line[col] == 1 && (col == w - 1 || line[col + 1] == -1)
                || (line[col] == -1 && (col == 0 || line[col - 1] == 1))) {
                return -1;
            }
            // make the move/roll the ball and check if you're outside wall col <0 sau col == w;
            col += line[col];
            if (col < 0 || col == w) {
                return -1;
            }
        }
        return col;
    }
}
