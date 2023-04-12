package com.ss.leetcode.LC2023.april;

public class CheckIfThereIsAValidPathInAGrid {
    // https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid
    /** Algorithm:
        1. Starting from cell [m][n] determine if you reach [0][0] if you walk on the road described/linked by each cell
        2. Use 4 directions to travel: UP (1), RIGHT 2, DOWN 3 and LEFT 4.
        3. Each cell/street has two modifiers, depending of the direction in which you ENTER this cell.
            - if you enter a cell 6 with a LEFT orientation, then your coords modifiers will be {-1, 0} (going up by 1 row)
            - if you enter a cell 6 with a DOWN orientation, then your coords modifiers will be {0, 1} (going left by 1 )
        4. Declare an array of 6 such objects, each with two modifiers, based on direction
        5. Pay special attention to edge case of [m][n]
            - if cell is 4. Return false immediately
            - if cell is 5, you could be stepping here from cell above or cell on the right, so you need to check both
        6. Starting from cell [m][n] step each cell and see if you reach [0][0].
            If you get stuck in a cell (cell 2 cannot connect to cell 1) or step outside matrix, return false.
        7. Use a recursive function to step each connected cell.
    */
    private static final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
    private static StreetConnection[] streets;
    public boolean hasValidPath(int[][] grid) {
        initializeStreets();
        int[] location = {grid.length -1, grid[0].length -1};
        int cellNo = grid[location[0]][location[1]];
        boolean canFinish;
        if (cellNo == 4) {
            canFinish = false;
        } else if (cellNo == 5) {
            int[] cloneLoc = {location[0], location[1]};
            canFinish = hasValidPath(RIGHT, location, grid) || hasValidPath(DOWN, cloneLoc, grid);
        } else {
            canFinish = hasValidPath(cellNo == 1 || cellNo == 6 ? LEFT : UP, location, grid);
        }
        return canFinish;
    }

    private boolean hasValidPath(int direction, int[] location, int[][] grid) {
        if (location[0] == 0 && location[1] == 0) {
            return true;
        }
        if (location[0] < 0 || location[0] >= grid.length || location[1] < 0 || location[1] >= grid[0].length) {
            return false;
        }
        StreetConnection currentCell = streets[grid[location[0]][location[1]]];
        int newDirection = currentCell.getNewCoordsAndDirection(direction, location);
        if (newDirection != -1) {
            return hasValidPath(newDirection, location, grid);
        } else {
            return false;
        }
    }

    private void initializeStreets() {
        if (streets == null) {
            streets = new StreetConnection[]{null,
                new StreetConnection(RIGHT, new int[]{0, 1}, LEFT, new int[]{0, -1}),
                new StreetConnection(UP, new int[]{-1, 0}, DOWN, new int[]{1, 0}),
                new StreetConnection(RIGHT, new int[]{1, 0}, UP, new int[]{0, -1}),
                new StreetConnection(LEFT, new int[]{1, 0}, UP, new int[]{0, 1}),
                new StreetConnection(DOWN, new int[]{0, -1}, RIGHT, new int[]{-1, 0}),
                new StreetConnection(DOWN, new int[]{0, 1}, LEFT, new int[]{-1, 0})};
        }
    }

    private static class StreetConnection {
        private int direction1, direction2;
        private int[] coefficient1, coefficient2;

        public StreetConnection(int d1, int[] c1, int d2, int[] c2) {
            this.direction1 = d1;
            this.coefficient1 = c1;
            this.direction2 = d2;
            this.coefficient2 = c2;
        }

        public int getNewCoordsAndDirection(int direction, int[] current) {
            int x = current[0];
            int y = current[1];
            if (direction == direction1) {
                current[0] += coefficient1[0];
                current[1] += coefficient1[1];
            } else if (direction == direction2) {
                current[0] += coefficient2[0];
                current[1] += coefficient2[1];
            } else {
                return -1;
            }
            return detectChangeOfDirection(x, y, current[0], current[1]);
        }

        private int detectChangeOfDirection(int oldX, int oldY, int newX, int newY) {
            if (oldX == newX) {
                return oldY < newY ? RIGHT : LEFT;
            } else {
                return oldX < newX ? DOWN : UP;
            }
        }
    }
}
