package com.ss.leetcode.LC2024.december;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    // https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] finalState = Arrays.copyOf(nums, nums.length);
        while (k-- > 0) {
            int minIndex = 0;
            for (int i = 1; i < finalState.length; i++) {
                if (finalState[i] < finalState[minIndex]) {
                    minIndex = i;
                }
            }
            finalState[minIndex] = finalState[minIndex] * multiplier;
        }
        return finalState;
    }
}
