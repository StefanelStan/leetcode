package com.ss.leetcode.LC2022.november;

public class NumberOfClosedIslands {
    // https://leetcode.com/problems/number-of-closed-islands/
    /** Algorithm
         1. Using DFS, traverse each cell and check if it's 0 and NOT on border.
         2. Use a boolean[][] seen to mark the visited cells
         3. A 0 cell that touches the edges becomes corrupt, meaning all the other cells connected/ via call stack trace will become
         corrupted, thus they cannot form a closed island.
         4. In a recursive method, try calling it via all 4 ways.
         5. However, if one call returns false, this means the cell cannot form an island, becoming corrupt.
         6. All other calls to a cell that is corrupted, will result in currupting those as well, thus not taking part in count
         7. If a cell has been seen, but it's not corrupted, return true and check the remaining direction.
     */
    public int closedIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        boolean[][] corrupted = new boolean[grid.length][grid[0].length];
        int closedIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !seen[i][j] && !corrupted[i][j] && isClosedIsland(grid, i, j, seen, corrupted)) {
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j, boolean[][] seen, boolean[][] corrupted) {
        // if it's on the edge and 0, then this cell becomes corrupted and will corrupt the caller
        if (i == 0 || i == grid.length -1 || j == 0 || j == grid[0].length - 1) {
            seen[i][j] = true;
            if (grid[i][j] == 0) {
                corrupted[i][j] = true;
                return false;
            } else {
                return true;
            }
        }

        seen[i][j] = true;
        boolean answer;
        // call up, right, down, left. The first call to return false will corrupt this cell as well.
        answer = checkIfCanTravel(grid, i-1, j, seen, corrupted);
        if (answer) {
            answer = checkIfCanTravel(grid, i, j + 1, seen, corrupted);
        }
        if (answer) {
            answer = checkIfCanTravel(grid, i+1, j, seen, corrupted);
        }
        if (answer) {
            answer = checkIfCanTravel(grid, i, j-1, seen, corrupted);
        }
        // if any calls returned false, means one of the cells were corrupted, so this cell needs to be corrupted.
        if (!answer) {
            corrupted[i][j] = true;
        }
        return answer;
    }

    private boolean checkIfCanTravel(int[][] grid, int i, int j, boolean[][] seen, boolean[][] corrupted) {
        if (seen[i][j] && corrupted[i][j]) {
            return false;
        }
        if (grid[i][j] == 1) {
            seen[i][j] = true;
            return true;
        }
        if (grid[i][j] == 0) {
            if (!seen[i][j]) {
                boolean answer = isClosedIsland(grid, i, j, seen, corrupted);
                seen[i][j] = true;
                if (!answer) {
                    corrupted[i][j] = true;
                    return false;
                }
            } else {
                return !corrupted[i][j];
            }
        }
        return true;
    }
}
