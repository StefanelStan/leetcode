package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPathInAMatrix {
    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
    // TLE -  some logic error
    public int longestIncreasingPath(int[][] matrix) {
        int[][] ascPaths = new int[matrix.length][matrix[0].length];
        int[] maxAscPath = {0};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (ascPaths[i][j] == 0) {
                    Map<Integer, int[]> pathSoFar = new HashMap<>();
                    findMaxPath(i, j, matrix, pathSoFar, ascPaths, maxAscPath);
                }
            }
        }
        return maxAscPath[0];
    }

    private void findMaxPath(int i, int j, int[][] matrix, Map<Integer, int[]> pathSoFar, int[][] ascPaths, int[] maxAscPath) {
        // do not enter here if you have bad i or j;
        if (ascPaths[i][j] != 0) {
            return;
        }
        int[] current = new int[]{i, j};
        pathSoFar.put(Arrays.hashCode(current), current);
        boolean setPath = false;
        if (i > 0 && matrix[i][j] < matrix[i-1][j] && !pathSoFar.containsKey(Arrays.hashCode(new int[]{i-1, j}))) {
            setPath = true;
            findMaxPath(i-1, j, matrix, new HashMap<>(pathSoFar), ascPaths, maxAscPath);
        }
        if (i < matrix.length -1 && matrix[i][j] < matrix[i+1][j] && !pathSoFar.containsKey(Arrays.hashCode(new int[]{i+1, j}))) {
            setPath = true;
            findMaxPath(i+1, j, matrix, new HashMap<>(pathSoFar), ascPaths, maxAscPath);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j-1] && !pathSoFar.containsKey(Arrays.hashCode(new int[]{i, j -1}))) {
            setPath = true;
            findMaxPath(i, j-1, matrix, new HashMap<>(pathSoFar), ascPaths, maxAscPath);
        }
        if (j < matrix[0].length -1 && matrix[i][j] < matrix[i][j+1] && !pathSoFar.containsKey(Arrays.hashCode(new int[]{i, j+1}))) {
            setPath = true;
            findMaxPath(i, j+1, matrix, new HashMap<>(pathSoFar), ascPaths, maxAscPath);
        }
        if (!setPath) {
            pathSoFar.forEach((k, v) -> ascPaths[v[0]][v[1]] = 1);
            maxAscPath[0] = Math.max(maxAscPath[0], pathSoFar.size());
        }
    }
}
