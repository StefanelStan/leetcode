package com.ss.leetcode.LC2023.june;

public class MaximumNumberOfFishInAGrid {
    // https://leetcode.com/problems/maximum-number-of-fish-in-a-grid
    /** Algorithm DFS:
        1. For i =0..n, j = 0..m, if current cell is water, jump on it and try catching the max nr of fish.
        2. Catching fish: recursive function that takes, grid, i, j and returns the max number of fish
            - if i,j outside the bounds or current cell is land, return 0
            - else add current cell to a return answer, set current cell to 0 and try fishing in the 4 directions, adding their values to return answer.
            - return the answer.
        3. Method #2 will traverse all linked water calls, catch their fish and mark the cells with 0
        4. #1 will then ignore these already fished cells.
     */
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, catchFish(grid, i, j));
                }
            }
        }
        return maxFish;
    }

    private int catchFish(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int fish = grid[i][j];
        grid[i][j] = 0;
        fish += catchFish(grid, i-1, j) + catchFish(grid, i, j+1) + catchFish(grid, i+1, j) + catchFish(grid, i, j-1);
        return fish;
    }
}
