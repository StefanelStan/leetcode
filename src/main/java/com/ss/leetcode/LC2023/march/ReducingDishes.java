package com.ss.leetcode.LC2023.march;

import java.util.Arrays;

public class ReducingDishes {
    // https://leetcode.com/problems/reducing-dishes
    /** Algorithm
        1. Sort them in increasing order. We are focusing on dishes with satisfaction >= 0.
        2. Find the first dish with satisfaction >= 0. Calculate the output from that point
        3. Moving left 1 by 1, calculate the new output. Break when the new one is lesser than prev one.
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        if (satisfaction[satisfaction.length -1] <= 0) {
            return 0;
        }
        int idx = 0, totalSum = 0, proposedSum = 0;
        while(idx < satisfaction.length && satisfaction[idx] < 0) {
            idx++;
        }
        totalSum = proposedSum = getSum(satisfaction, idx);
        idx--;
        while (idx >= 0 && proposedSum >= totalSum) {
            proposedSum = getSum(satisfaction, idx);
            if (proposedSum >= totalSum) {
                totalSum = proposedSum;
            }
            idx--;
        }
        return totalSum;
    }

    private int getSum(int[] satifaction, int from) {
        int sum = 0;
        for (int i = from; i < satifaction.length; i++) {
            sum += satifaction[i] * ((i - from) + 1);
        }
        return sum;
    }
}
