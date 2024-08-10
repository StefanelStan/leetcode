package com.ss.leetcode.LC2024.august;

public class RegionsCutBySlashes {
    // https://leetcode.com/problems/regions-cut-by-slashes
    /** Algorithm
        1. Looking at the most basic slash [/], this one actually divided the single cell into 2 halfs, so it counts as 2 regions
        2. To each up the computation, expand each cell into a 3 x 3 cells.
            - each / will mark/flag/block on cells [0,2][1,1][2,0] and \ will mark/block cells [0,0][1,1][2,2]
            - thus, with a slash / we still have cells [0,0] and [2,2] that are "free" and can count as 2 regions.
        3. Using this expanded matrix, traverse and mark any "unmarked" cells. (BFS OR DFS), jumping from a good cell to another good cell.
            - grid[i][charAt(j)] will be middle of the 3x3 cell that has the centre on [3 * i + 1, 3 * j + 1].
     */
    public int regionsBySlashes(String[] grid) {
        int regions = 0;
        boolean[][] expandedGrid = getExpandedGrid(grid);
        for (int i = 0; i < expandedGrid.length; i++) {
            for (int j = 0; j < expandedGrid[0].length; j++) {
                if (!expandedGrid[i][j]) {
                    markRegion(expandedGrid, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private boolean[][] getExpandedGrid(String[] grid) {
        char ch;
        boolean[][] expanded = new boolean[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ch = grid[i].charAt(j);
                if (ch == '/') {
                    expanded[3 * i + 1][3 * j + 1] = true;
                    expanded[3 * i][3 * j + 2] = true;
                    expanded[3 * i + 2][3 * j] = true;
                } else if (ch == '\\') {
                    expanded[3 * i + 1][3 * j + 1] = true;
                    expanded[3 * i][3 * j] = true;
                    expanded[3 * i + 2][3 * j + 2] = true;
                }
            }
        }
        return expanded;
    }

    private void markRegion(boolean[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !grid[i][j]) {
            grid[i][j] = true;
            markRegion(grid, i - 1, j);
            markRegion(grid, i, j + 1);
            markRegion(grid, i + 1, j);
            markRegion(grid, i, j - 1);
        }
    }
}
