package com.ss.leetcode.LC2021.september;

public class LargestPlusSign {
    // https://leetcode.com/problems/largest-plus-sign/
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] minedField = minedField(n, mines);
        int maxPlus = 0;
        for (int i = maxPlus; i <= Math.max(n - 1, n - 1 - maxPlus); i++) {
            for (int j = maxPlus; j <= Math.max(n - 1, n - 1 - maxPlus); j++) {
                if (!minedField[i][j]) {
                    maxPlus = Math.max(maxPlus, 1 + getMaxPlus(i, j, 1, minedField));
                }
            }
        }
        return maxPlus;
    }

    private boolean[][] minedField(int n, int[][] mines) {
        boolean[][] minedField = new boolean[n][n];
        for (int[] mine : mines) {
            minedField[mine[0]][mine[1]] = true;
        }
        return minedField;
    }

    private int getMaxPlus(int i, int j, int level, boolean[][] minedField) {
        if (i - level < 0 || i + level >= minedField.length || j - level < 0 || j + level >= minedField.length) {
            return 0;
        }
        if (!minedField[i - level][j] && !minedField[i][j + level] && !minedField[i + level][j] && !minedField[i][j - level]) {
            return 1 + getMaxPlus(i, j, level + 1, minedField);
        } else {
            return 0;
        }
    }
}
