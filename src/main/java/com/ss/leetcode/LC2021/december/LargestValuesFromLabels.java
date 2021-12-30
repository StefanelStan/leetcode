package com.ss.leetcode.LC2021.december;

import java.util.Arrays;
import java.util.Comparator;

public class LargestValuesFromLabels {
    // https://leetcode.com/problems/largest-values-from-labels/
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] matLabels = new int[values.length][2];
        for (int i = 0; i < matLabels.length; i++) {
            matLabels[i][0] = values[i];
            matLabels[i][1] = labels[i];
        }

        Arrays.sort(matLabels, Comparator.comparingInt(a -> a[0]));
        // group and sort them
    }
}
