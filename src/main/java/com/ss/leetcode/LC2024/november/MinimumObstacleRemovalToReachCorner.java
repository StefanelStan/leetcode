package com.ss.leetcode.LC2024.november;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumObstacleRemovalToReachCorner {
    private static final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0, -1}};
    public int minimumObstacles(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = grid[0][0];
        traverseGrid(grid, cost);
        return cost[cost.length - 1][cost[0].length - 1];
    }

    private void traverseGrid(int[][] grid, int[][] cost) {
        PriorityQueue<int[]> costQueue = new PriorityQueue<>(Comparator.comparingInt(a -> cost[a[0]][a[1]]));
        costQueue.add(new int[]{0, 0});
        int[] nextNode;
        int nextX, nextY;
        while (!costQueue.isEmpty()) {
            nextNode = costQueue.poll();
            for (int[] direction : DIRECTIONS) {
                nextX = nextNode[0] + direction[0];
                nextY = nextNode[1] + direction[1];
                if (shouldVisitNode(nextNode[0], nextNode[1], nextX, nextY, grid, cost)) {
                    cost[nextX][nextY] = cost[nextNode[0]][nextNode[1]] + grid[nextX][nextY];
                    costQueue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private boolean shouldVisitNode(int x, int y, int nextX, int nextY, int[][] grid, int[][] cost) {
        return nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && cost[x][y] + grid[nextX][nextY] < cost[nextX][nextY];
    }
}
