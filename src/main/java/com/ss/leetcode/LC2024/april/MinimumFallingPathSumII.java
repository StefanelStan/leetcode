package com.ss.leetcode.LC2024.april;

import java.util.Arrays;

public class MinimumFallingPathSumII {
    // https://leetcode.com/problems/minimum-falling-path-sum-ii
    /** Algorithm
        1. Apply bottom up technique.
        2. EG: row n -2, index = 0.
            - the minFallingPath[n-2][index] is grid[n-2][index] + next rows's minValue from column 1 -> m-1
        3. As observed, we need to precompute an int[] minFromRight
            - We don't need to precompute minFromLeft becuase we will do a prefixMin when we traverse each column
        4. For index i = 1, row = n -2
            - minFallingPath[n-2][1] = grid[n-2][1] + min(prefixMin, minFromRight[2])
        5. Return the min value precomputed at the top row.
     */
    public int minFallingPathSum(int[][] grid) {
        for (int i = grid.length - 2; i >= 0; i--) {
            setMinPathSum(grid, i);
        }
        return Arrays.stream(grid[0]).min().getAsInt();
    }

    private void setMinPathSum(int[][] grid, int row) {
        int[] minFromRight = getMinFromRight(grid, row + 1);
        int minFromLeft = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length - 1; j++) {
            grid[row][j] += Math.min(minFromLeft, minFromRight[j + 1]);
            minFromLeft = Math.min(minFromLeft, grid[row + 1][j]);
        }
        // last column does not have minimum on right side
        grid[row][grid[0].length - 1] = minFromLeft + grid[row][grid[0].length - 1];
    }

    private int[] getMinFromRight(int[][] grid, int row) {
        int[] minFromRight = new int[grid[0].length];
        minFromRight[minFromRight.length - 1] = grid[row][minFromRight.length - 1];
        for (int j = minFromRight.length - 2; j >= 0; j--) {
            minFromRight[j] = Math.min(grid[row][j], minFromRight[j + 1]);
        }
        return minFromRight;
    }
}
