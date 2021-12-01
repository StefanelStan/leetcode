package com.ss.leetcode.LC2021.march;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topBottomSkyline = getTopBottonSkyline(grid);
        int[] leftRightSkyline = getLeftRightSkyline(grid);
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Math.min(topBottomSkyline[j], leftRightSkyline[i]) - grid[i][j];
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }

        return sum;
    }

    private int[] getTopBottonSkyline(int[][] grid) {
        int[] skyline = new int[grid[0].length];
        int maxCol;
        for (int j = 0; j < grid[0].length; j++) {
            maxCol = 0;
            for (int[] ints : grid) {
                if (ints[j] > maxCol) {
                    maxCol = ints[j];
                }
            }
            skyline[j] = maxCol;
        }
        return skyline;
    }

    private int[] getLeftRightSkyline(int[][] grid) {
        int[] skyline = new int[grid.length];
        int maxLine;
        for (int i = 0; i < grid.length; i++) {
            maxLine = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > maxLine) {
                    maxLine = grid[i][j];
                }
            }
            skyline[i] = maxLine;
        }
        return skyline;
    }
}
