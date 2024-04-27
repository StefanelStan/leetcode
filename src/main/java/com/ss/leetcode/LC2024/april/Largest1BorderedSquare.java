package com.ss.leetcode.LC2024.april;

public class Largest1BorderedSquare {
    // https://leetcode.com/problems/largest-1-bordered-square
    /** Algorithm
        1. Compute the row and column prefixes of count of 1 and store them in an 2 x int[][]
            - EG: [[1,1,0,0,1],[0,1,0,1,0]
            - rowPrefix [[1,2,2,2,3],[0,1,1,2,2]] -> count of 1s on each row
            - colPrefix [[1,1,0,0,1],[1,2,0,1,1]] -> count of 1s on each column by row.
        2. Knowing this, we can apply interval count:
            - number of 1s at on row 0 between index 3 and 7 is rowPrefix[0][7] - rowPrefix[0][2].
            - number of 1s on column 3 between rows 2 and 8 is colPrefix[8][3] - colPrefix[1][3]
        3. In 2 fors (i - rows, j columns, stopping when i,j < length - range)
            - Find the further diagonal point from i & j that sits at the edge of a square.
            - the furthest point if Math.min(n - i, m - j)
            - From the furthest, try to determine if the 4 borders (aka interval counts) equal range.
            - Stop when you find a range or when current range goes below the largest range found so far.
     */
    public int largest1BorderedSquare(int[][] grid) {
        int[][] rowPrefix = new int[grid.length][grid[0].length];
        int[][] colPrefix = new int[grid.length][grid[0].length];
        getPrefixes(grid, rowPrefix, colPrefix);
        return findLargestBorder(grid, rowPrefix, colPrefix);
    }

    private void getPrefixes(int[][] grid, int[][] rowPrefix, int[][] colPrefix) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowPrefix[i][j] = grid[i][j] + (j == 0 ? 0 : rowPrefix[i][j - 1]);
                colPrefix[i][j] = grid[i][j] + (i == 0 ? 0 : colPrefix[i - 1][j]);
            }
        }
    }

    private int findLargestBorder(int[][] grid, int[][] rowPrefix, int[][] colPrefix) {
        int largest = 0;
        boolean found = false;
        for (int i = 0; i < grid.length - largest; i++) {
            for (int j = 0; j < grid[i].length - largest; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    largest = Math.max(largest, shrinkBorder(grid, i, j, rowPrefix, colPrefix, largest));
                }
            }
        }
        return !found ? 0 : (int)Math.pow(1 + largest, 2);
    }

    private int shrinkBorder(int[][] grid, int x, int y, int[][] rowPrefix, int[][] colPrefix, int largest) {
        int range = Math.min(grid.length - x, grid[0].length - y) - 1;
        while (range > largest) {
            if (isValidBorder(grid, x, y, range, rowPrefix, colPrefix)) {
                break;
            }
            range--;
        }
        return range;
    }

    private boolean isValidBorder(int[][] grid, int x, int y, int range, int[][] rowPrefix, int[][] colPrefix) {
        return 1 + range == rowPrefix[x][y + range] - (y == 0 ? 0 : rowPrefix[x][y-1])
            && 1 + range == rowPrefix[x + range][y + range] - (y == 0 ? 0 : rowPrefix[x + range][y-1])
            && 1 + range == colPrefix[x + range][y] - (x == 0 ? 0 : colPrefix[x-1][y])
            && 1 + range == colPrefix[x + range][y + range] - (x == 0 ? 0 : colPrefix[x-1][y + range]);
    }
}
