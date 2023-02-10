package com.ss.leetcode.LC2023.february;

public class AsFarFromLandAsPossible {
    // https://leetcode.com/problems/as-far-from-land-as-possible
    /** Algorithm
        1. Build an int[][] distances. If grid[i][j] = 1, distance[i][j] == 0, otherwise 201.
        2. Traverse the matrix twice: line by line from 0 to n (left to right)
            and once line by line from down to up, left to right.
        3. When traversing from up -> down, left and right,
            - if grid[i][j] == 0, leave distance[i][j] as is (it is land)
            - ELSE, look up 1 cell and look left one cell.
            Make distance[i][j] = Math.min (distance[i][j], 1 + distance[i-1][j], 1 + distance[i][j-1]).
            This way you set your current distance to check the closest cell and how close is that to the land
        4. Second traversal: do the same, but this time look one cell down and one cell right.
            Set distance[i][j] = Math.min(distance[i][j], 1 + distance[i+1][j], 1 + distance[i][j+1])
        5. These two traversals will check the set the minimum distance to the closest lands.
        6. Traverse the matrix and find the max distance. If max is 0 or 201, return -1.
     */
    private static final int MAX_DISTANCE = 201;
    public int maxDistance(int[][] grid) {
        int[][] distances = buildDistances(grid);
        for (int i = 0; i < grid.length; i++) {
            markLine(distances, grid, i, 0, grid.length, 1);
        }
        for (int i = grid.length -1; i >= 0; i--) {
            markLine(distances, grid, i, grid.length -1, -1, -1);
        }
        int maxDist = getMaxDist(distances);
        return maxDist == 0 || maxDist == MAX_DISTANCE ? -1 : maxDist;
    }

    // when traversing up - down, left right, start will be 0  end = length
    // when traversing down-up, right, left, start with be length -1 end = -1;
    private void markLine(int[][] distances, int[][] grid, int i, int start, int stop, int sign) {
        for (int j = start; j != stop; j+= sign) {
            if (grid[i][j] == 0) {
                if (j + (-sign) >= 0 && j + (-sign) < grid.length) {
                    distances[i][j] = Math.min(distances[i][j], 1 + distances[i][j + -sign]);
                }
                if (i + (-sign) >= 0 && i + (-sign) < grid.length) {
                    distances[i][j] = Math.min(distances[i][j], 1 + distances[i + -sign][j]);
                }
            }
        }
    }

    private int[][] buildDistances(int[][] grid) {
        int[][] distances = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    distances[i][j] = MAX_DISTANCE;
                }
            }
        }
        return distances;
    }

    private int getMaxDist(int[][] distances) {
        int maxDist = 0;
        for (int[] line : distances) {
            for (int item : line) {
                maxDist = Math.max(maxDist, item);
            }
        }
        return maxDist;
    }
}
