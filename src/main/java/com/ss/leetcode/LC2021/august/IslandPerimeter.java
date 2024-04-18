package com.ss.leetcode.LC2021.august;

public class IslandPerimeter {
    // https://leetcode.com/problems/island-perimeter/
    /** Algorithm
        1. If a cell has NO upper land, it will contribute with 2 points
        2. If a call has NO left land, it will contribute with 2 points
        3. Traverse matrix and for each cell, if 1, check upper/left.
            - if left is 0 or outside, it will contribute 2, else 0 points to perimeter.
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += getEdgeValue(i - 1, j, grid) + getEdgeValue(i, j - 1, grid);
                }
            }
        }
        return perimeter;
    }

    private int getEdgeValue(int x, int y, int[][] grid) {
        return x < 0 || y < 0 || grid[x][y] == 0 ? 2 : 0;
    }


    public int islandPerimeter2(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += countSquarePerimeter(i, j, grid);
                }
            }
        }
        return perimeter;
    }

    private int countSquarePerimeter(int i, int j, int[][] grid) {
        int perimeter = 4;
        if(j != 0 && grid[i][j - 1] == 1) {
            perimeter -= 2;
        }
        if (i != 0 && grid[i - 1][j] == 1) {
            perimeter -= 2;
        }
        return perimeter;
    }
}
