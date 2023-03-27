package com.ss.leetcode.LC2023.march;

public class DetectCyclesIn2DGrid {
    // https://leetcode.com/problems/detect-cycles-in-2d-grid
    /** Algorithm
        1. Start traversing the grid from 0,0 in all 4 ways using a recursive method.
        2. Use a boolean[][] visited to keep track of the cells you have visited.
        3. The recursive method: if i,j are outside the grid OR current char is different from char from #1, return
        4. If you have landed on a cell that you previously visited, then return true
        5. Jumping in the grid with the helper method: You also need to pass an int to mark the direction you are coming from and jumping to.
            EG: If you jump from [0,0] to [0,1] and then from [0,1] back to [0,0] then you might think you have a cycle.
            That's why when jumping, also pass an int direction (1-up, 2-right etc).
            So if you have jumped right, then you cannot jump back left (0 -> 1 -> 0) but only in the other 3 remaining directions.
            This way we avoid the false positives when jumping forward and them back.
        6. Keep jumping in the directions that are not tacking you back to the direction you previously jumped from.
            Return true when you land on a previously visited cell.
     */
    private final int up = 1, right = 2, down = 3, left = 4;
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean[] containsCycle = {false};
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m && !containsCycle[0]; i++) {
            for (int j = 0; j < n && !containsCycle[0]; j++) {
                if (!visited[i][j]) {
                    visitCells(grid, grid[i][j], i, j, 0, visited, containsCycle);
                }
            }
        }
        return containsCycle[0];
    }

    private void visitCells(char[][] grid, char origChar, int i, int j, int from, boolean[][] visited, boolean[] containsCycle) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != origChar || containsCycle[0]) {
            return;
        }
        if (visited[i][j]) {
            containsCycle[0] = true;
        } else {
            visited[i][j] = true;
            if (from != down) {
                visitCells(grid, origChar, i - 1, j, up, visited, containsCycle);
            }
            if (from != up && !containsCycle[0]) {
                visitCells(grid, origChar, i + 1, j, down, visited, containsCycle);
            }
            if (from != left && !containsCycle[0]) {
                visitCells(grid, origChar, i, j + 1, right, visited, containsCycle);
            }
            if (from != right && !containsCycle[0]) {
                visitCells(grid, origChar, i, j - 1, left, visited, containsCycle);
            }
        }
    }
}
