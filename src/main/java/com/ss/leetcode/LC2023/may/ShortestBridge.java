package com.ss.leetcode.LC2023.may;

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {
    // https://leetcode.com/problems/shortest-bridge
    public int shortestBridge(int[][] grid) {
        List<List<int[]>> islands = getIslands(grid);
        return getShortestBridge(islands.get(0), islands.get(1));
    }

    private List<List<int[]>> getIslands(int[][] grid) {
        List<List<int[]>> islands = new ArrayList<>(2);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> island = new ArrayList<>();
                    traverseAndGetIsland(grid, i, j, island);
                    islands.add(island);
                }
            }
        }
        return islands;
    }

    private void traverseAndGetIsland(int[][] grid, int i, int j, List<int[]> island) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        island.add(new int[]{i,j});
        traverseAndGetIsland(grid, i - 1, j, island);
        traverseAndGetIsland(grid, i, j + 1, island);
        traverseAndGetIsland(grid, i + 1, j, island);
        traverseAndGetIsland(grid, i, j -1 , island);
    }

    private int getShortestBridge(List<int[]> island1, List<int[]> island2) {
        int shortestBridge = Integer.MAX_VALUE;
        for (int[] land1 : island1) {
            for (int[] land2 : island2) {
                shortestBridge = Math.min(shortestBridge, Math.abs(land1[0] - land2[0]) + Math.abs(land1[1] - land2[1]));
            }
        }
        return shortestBridge - 1;
    }
}
