package com.ss.leetcode.LC2023.november;

public class CheckKnightTourConfiguration {
    // https://leetcode.com/problems/check-knight-tour-configuration
    /** Algorithm
        1. Use a int[][] MOVES to describe the 8 moves/differences in x & y coordinates.
            top right is x -2, y+1 => {-2, 1}.
        2. Use a recursive function that will take current jumpIndex, grid, x/y and will check if
            your are inside the grid and your grid[x][y] == jumpIndex.
        3. If yes, then try to jump on all the 8 positions, checking if your current cell matches desired index
        4. Recursively, return when you found one good jump. Stop when your current index matches n*m -1.
     */
    private static final int[][] MOVES = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public boolean checkValidGrid(int[][] grid) {
        return jumpOnBoard(0, grid, 0, 0);
    }

    private boolean jumpOnBoard(int jumpIndex, int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != jumpIndex) {
            return false;
        }
        if (jumpIndex == grid.length * grid[0].length - 1) {
            return true;
        }
        boolean foundGoodJump = false;
        for (int i = 0; i < MOVES.length && !foundGoodJump; i++) {
            foundGoodJump = jumpOnBoard(jumpIndex + 1, grid, x + MOVES[i][0], y + MOVES[i][1]);
        }
        return foundGoodJump;
    }
}
