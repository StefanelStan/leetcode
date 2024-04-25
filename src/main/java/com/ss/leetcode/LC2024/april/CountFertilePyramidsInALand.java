package com.ss.leetcode.LC2024.april;

public class CountFertilePyramidsInALand {
    // https://leetcode.com/problems/count-fertile-pyramids-in-a-land
    public int countPyramids(int[][] grid) {
        int[][] pyramidPoints = getPyramidPoints(grid);
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                total += grid[i][j] == 0 ? 0 : countPyramids(pyramidPoints, i, j);
            }
        }
        return total;
    }

    private int countPyramids(int[][] pyramidPoints, int i, int j) {
        int total = 0;
        int index = 1, range = 3;
        for (; i - index >= 0 && pyramidPoints[i - index][j] >= range; index++, range += 2) {
            total++;
        }
        for (index = 1, range = 3; i + index < pyramidPoints.length && pyramidPoints[i + index][j] >= range; index++, range += 2) {
            total++;
        }
        return total;
    }

    private int[][] getPyramidPoints(int[][] grid) {
        int[][] pyramidPoints = new int[grid.length][grid[0].length];
        int rowCount;
        for (int i = 0; i < grid.length; i++) {
            rowCount = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount++;
                } else {
                    markPyramidPoints(pyramidPoints, i, j - 1, rowCount);
                    rowCount = 0;
                }
            }
            markPyramidPoints(pyramidPoints, i, grid[i].length - 1, rowCount);
        }
        return pyramidPoints;
    }

    private void markPyramidPoints(int[][] pyramidPoints, int i, int j, int count) {
        if (count < 3 || pyramidPoints[i][j - count / 2] >= count) {
            return;
        }
        // if odd
        if (count % 2 == 1) {
            pyramidPoints[i][j - count / 2] = Math.max(pyramidPoints[i][j - count / 2], count);
            markPyramidPoints(pyramidPoints, i, j - 2, count - 2);
            markPyramidPoints(pyramidPoints, i, j, count - 2);
        } else {
            markPyramidPoints(pyramidPoints, i, j, count - 1);
            markPyramidPoints(pyramidPoints, i, j - 1, count - 1);
        }
    }
}
