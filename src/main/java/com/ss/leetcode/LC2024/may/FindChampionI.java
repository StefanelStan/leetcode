package com.ss.leetcode.LC2024.may;

public class FindChampionI {
    // https://leetcode.com/problems/find-champion-i
    public int findChampion(int[][] grid) {
        boolean[] isWeak = new boolean[grid.length];
        int weak;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i != j) {
                    weak = grid[i][j] == 1 ? j : i;
                    isWeak[weak] = true;
                }
            }
        }
        for (int i = 0; i < isWeak.length; i++) {
            if (!isWeak[i]) {
                return i;
            }
        }
        return -1;
    }
}
