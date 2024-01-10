package com.ss.leetcode.LC2024.january;

import java.util.Arrays;

public class MinimumPathCostInAGrid {
    // https://leetcode.com/problems/minimum-path-cost-in-a-grid
    /** Algorithm
        1. You need to build the array from bottom up: row[n-2][j] needs to know the cost to travel from row[n-1] to row[n-2][j]
        2. For i = n-2..0, for j = 0..m-1 (each cell) you need to determine the candidateCost from row below into current cell
        3. Get the travel cost array from that cell to row below: moveCost[grid[i][j]]
        4. For each k element of moveCost[grid[i][j]], (stepCost), your candidateCost is the min between
            candidateCost and stepCost + value_of_cell_under (grid[i+1][k])
        5. Add the candidateCost from row below to current cell into the current cell: grid[i][j] += candidateCost
        6. Return the min value from grid[0].
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int candidateCost, stepCost;
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                candidateCost = Integer.MAX_VALUE;
                for (int k = 0; k < moveCost[0].length; k++) {
                    stepCost = moveCost[grid[i][j]][k];
                    candidateCost = Math.min(candidateCost, stepCost + grid[i+1][k]);
                }
                grid[i][j] += candidateCost;
            }
        }
        return Arrays.stream(grid[0]).min().getAsInt();
    }
}
