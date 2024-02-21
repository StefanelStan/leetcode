package com.ss.leetcode.LC2024.february;

public class CountSubIslands {
    // https://leetcode.com/problems/count-sub-islands
    /** Algorithm
        1. Traverse grid2 and if current cell is 1, apply DFS and try to determine if all the 1 linked cells are part of an island from grid 1
        2. DFS:
            - if current x/y is outside the matrix OR current cell from grid2 is 0, return true. (as you could have already traversed it)
            - initialize a boolean valid isValid = grid1[i][j] == 1;
            - set current cell from grid2 to be 0
            - jump in all 4 directions and apply logical AND (pay attention to short-circuit AND)
        3. If the return from current search it true, then you have a subisland.
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && isValidSubIsland(i, j, grid1, grid2)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean isValidSubIsland(int i, int j, int[][] grid1, int[][] grid2) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }
        boolean isValid = grid1[i][j] == 1 && grid2[i][j] == 1;
        grid2[i][j] = 0;
        isValid = isValidSubIsland(i - 1, j, grid1, grid2) && isValid;
        isValid = isValidSubIsland(i, j + 1, grid1, grid2) && isValid;
        isValid = isValidSubIsland(i + 1, j, grid1, grid2) && isValid;
        isValid = isValidSubIsland(i, j - 1, grid1, grid2) && isValid;
        return isValid;
    }
}
