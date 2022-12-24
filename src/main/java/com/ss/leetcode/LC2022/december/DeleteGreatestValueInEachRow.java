package com.ss.leetcode.LC2022.december;

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {
    // https://leetcode.com/problems/delete-greatest-value-in-each-row
    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int greatestVals = 0;
        int maxToRemoveThisRound;
        for (int j = grid[0].length -1; j >= 0; j--) {
            maxToRemoveThisRound = -1;
            for (int[] ints : grid) {
                maxToRemoveThisRound = Math.max(maxToRemoveThisRound, ints[j]);
            }
            greatestVals += maxToRemoveThisRound;
        }
        return greatestVals;
    }
}
