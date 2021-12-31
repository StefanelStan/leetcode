package com.ss.leetcode.LC2021.december;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValuesFromLabels {
    // https://leetcode.com/problems/largest-values-from-labels/
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] numbersAndLabels = new int[values.length][2];
        int largestVal = 0;
        for (int i = 0; i < numbersAndLabels.length; i++) {
            numbersAndLabels[i][0] = values[i];
            numbersAndLabels[i][1] = labels[i];
        }
        Arrays.sort(numbersAndLabels, (a, b) -> Integer.compare(b[0], a[0]));
        // group and sort them
        Map<Integer, Integer> usedLabels = new HashMap<>();
        for (int i = 0; i < numbersAndLabels.length && numWanted > 0; i++) {
            Integer usedLabel = usedLabels.get(numbersAndLabels[i][1]);
            if(usedLabel == null || usedLabel < useLimit) {
                usedLabels.merge(numbersAndLabels[i][1], 1, Integer::sum);
                largestVal += numbersAndLabels[i][0];
                numWanted--;
            }
        }
        return largestVal;
    }
}
