package com.ss.leetcode.LC2022.august;

public class LargestLocalValuesInAMatrix {
    // https://leetcode.com/problems/largest-local-values-in-a-matrix/
    /** Algorithm
        1. Each segment matrix[i][j,j+1, j+2] can be part of 3 blocks. (Depending on edge cases of i > 0 and i < n-2).
        2. It can be the top row of a matrix,
        3. It can be middle row of a matrix with top row at matrix[i-1][j]
        4. It can be the bottom row of a matrix with top row at matrix[i-2][j].
        5. Traverse and for each segment update the 3 possible results in maxLocal matrix (depending on applicability).
     */
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length -2][grid.length -2];
        for (int i = 0; i < grid.length; i++) {
            processRow(grid[i], i, grid.length, maxLocal);
        }
        return maxLocal;
    }

    private void processRow(int[] row, int i, int maxRows, int[][] maxLocal) {
        int segmentMax;
        for (int j = 0; j < row.length - 2; j++) {
            segmentMax = Math.max(row[j], Math.max(row[j+1], row[j+2]));
            setLocal(segmentMax, i, j, maxRows, maxLocal); // can this x/y be a top row of a 3x3 matrix
            setLocal(segmentMax, i - 1, j, maxRows, maxLocal); // can this x/y be a middle row of a 3x3 matrix
            setLocal(segmentMax, i - 2, j, maxRows, maxLocal); // can this x/y be a bottom row of a 3x3 matrix
        }
    }

    private void setLocal(int segmentMax, int i, int j, int maxRows, int[][] maxLocal) {
        if (i >= 0 && i < maxRows - 2) {
            maxLocal[i][j] = Math.max(maxLocal[i][j], segmentMax);
        }
    }

    /** Algorithm
         1. Declare a result[n-2][n-2] matrix that will hold the result.
         2. In a loop with i=[0,n-2) and j=[0,n-2), set result[][] the max of each square (i->i+2 j->j+2).
         3. Return the result.
     */
    public int[][] largestLocal2(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for (int i = 0; i < n -2; i++) {
            for (int j = 0; j < n-2; j++) {
                result[i][j] = getMax(grid, i, j);
            }
        }
        return result;
    }

    private int getMax(int[][] grid, int row, int col) {
        int max = grid[row][col];
        for (int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
