package com.ss.leetcode.LC2022.november;

import java.util.Arrays;

public class NearestExitFromEntranceInMaze {
    // https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
    // TLE
    private static final int MAX = 10_001;
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] nearestExit = {MAX};
        int[][] walkCost = getWalkCost(maze.length, maze[0].length);
        getNearestExit(maze, entrance[0], entrance[1], walkCost, 0, entrance, nearestExit);
        return nearestExit[0] == MAX ? -1 : nearestExit[0];
    }

    int[][] getWalkCost(int rows, int columns) {
        int[][] cost = new int[rows][columns];
        for(int[] row : cost) {
            Arrays.fill(row, MAX);
        }
        return cost;
    }

    private void getNearestExit(char[][] maze, int i, int j, int[][] walkCost, int currentCost, int[] entrance, int[] nearestExit) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == '+' || walkCost[i][j] <= currentCost) {
            return;
        }
        walkCost[i][j] = currentCost;
        if ((i == 0 || i == maze.length -1 || j == 0 || j == maze[0].length - 1) && (i != entrance[0] || j != entrance[1])) {
            nearestExit[0] = Math.min(nearestExit[0], currentCost);
        } else {
            getNearestExit(maze, i + 1, j, walkCost, currentCost + 1, entrance, nearestExit);
            getNearestExit(maze, i, j + 1, walkCost, currentCost + 1, entrance, nearestExit);
            getNearestExit(maze, i - 1, j, walkCost, currentCost + 1, entrance, nearestExit);
            getNearestExit(maze, i, j - 1, walkCost, currentCost + 1, entrance, nearestExit);
        }
    }
}
