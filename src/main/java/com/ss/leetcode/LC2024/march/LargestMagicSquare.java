package com.ss.leetcode.LC2024.march;

public class LargestMagicSquare {
    // https://leetcode.com/problems/largest-magic-square
    public int largestMagicSquare(int[][] grid) {
        int[][] colPrefix = getColPrefix(grid);
        int[][] rowPrefix = getRowPrefix(grid);
        int largestEdge = 0;
        for (int i = 0; i < grid.length - largestEdge; i++) {
            for (int j = 0; j < grid[0].length - largestEdge; j++) {
                largestEdge = Math.max(largestEdge, findLargestEdge(i, j, largestEdge, colPrefix, rowPrefix, grid));
            }
        }
        return largestEdge + 1;
    }

    private int findLargestEdge(int i, int j, int largestEdge, int[][] colPrefix, int[][] rowPrefix, int[][] grid) {
        int maxRange = Math.min(grid.length - i, grid[i].length - j) - 1;
        while (maxRange > largestEdge) {
            if(isValidSquare(i, j, maxRange, colPrefix, rowPrefix, grid)) {
                return maxRange;
            }
            maxRange--;
        }
        return largestEdge;
    }

    private boolean isValidSquare(int i, int j, int range, int[][] colPrefix, int[][] rowPrefix, int[][] grid) {
        int diagSum1 = diagSum(i, j, i+range, 1, grid);
        int diagSum2 = diagSum(i, j+range, i+range, -1, grid);
        return diagSum1 == diagSum2 && eachRowsAreEqual(i, j, range, diagSum1, rowPrefix) && eachColsAreEqual(i, j, range, diagSum1, colPrefix);
    }

    private boolean eachRowsAreEqual(int i, int j, int range, int diagSum, int[][] rowPrefix) {
        boolean areEqual = true;
        int chunkSum = 0;
        for (int k = 0; k <= range && areEqual; k++) {
            chunkSum = rowPrefix[i+k][j+range] - (j == 0 ? 0 : rowPrefix[i+k][j-1]);
            areEqual = diagSum == chunkSum;
        }
        return areEqual;
    }

    private boolean eachColsAreEqual(int i, int j, int range, int diagSum, int[][] colPrefix) {
        boolean areEqual = true;
        int chunkSum = 0;
        for (int k = 0; k <= range && areEqual; k++) {
            chunkSum = colPrefix[i+range][j+k] - (i == 0 ? 0 : colPrefix[i-1][j+k]);
            areEqual = diagSum == chunkSum;
        }
        return areEqual;
    }

    private int diagSum(int i, int j, int iStop, int jIndex, int[][] grid) {
        int diagSum = 0;
        while (i <= iStop) {
            diagSum += grid[i][j];
            i++;
            j += jIndex;
        }
        return diagSum;
    }

    private int[][] getColPrefix(int[][] grid) {
        int[][] colPrefix = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            calculateSum(0, j, 1, 0, colPrefix, grid);
        }
        return colPrefix;
    }

    private int[][] getRowPrefix(int[][] grid) {
        int[][] rowPrefix = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            calculateSum(i, 0, 0, 1, rowPrefix, grid);
        }
        return rowPrefix;
    }

    private void calculateSum(int i, int j, int iIncr, int jIncr, int[][] prefix, int[][] grid) {
        int sum = 0;
        while(i < grid.length && j < grid[0].length) {
            sum += grid[i][j];
            prefix[i][j] = sum;
            i += iIncr;
            j += jIncr;
        }
    }
}
