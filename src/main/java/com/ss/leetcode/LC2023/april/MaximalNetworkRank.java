package com.ss.leetcode.LC2023.april;

public class MaximalNetworkRank {
    // https://leetcode.com/problems/maximal-network-rank
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length <= 1) {
            return roads.length;
        }
        boolean[][] adjacencyMatrix = new boolean[n][n];
        int[] inDegree = new int[n];
        connectCities(roads, adjacencyMatrix, inDegree);
        return getMaxRank(adjacencyMatrix, inDegree);
    }

    private int getMaxRank(boolean[][] connected, int[] inDegree) {
        int max = 0, current = 0;
        for (int i = 0; i < connected.length - 1; i++) {
            for (int j = i +1; j < connected.length; j++) {
                current = inDegree[i] + inDegree[j] + (connected[i][j] ? -1 : 0);
                max = Math.max(max, current);
            }
        }
        return max;
    }

    private void connectCities(int[][] roads, boolean[][] matrix, int[] inDegree) {
        for(int[] road : roads) {
            matrix[road[0]][road[1]] = true;
            matrix[road[1]][road[0]] = true;
            inDegree[road[0]]++;
            inDegree[road[1]]++;
        }
    }
}
