package com.ss.leetcode.november;

public class MinimumValueToGetPositiveStepSum {
    // https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    public int minStartValue(int[] nums) {
        int minStepSum = Integer.MAX_VALUE;
        int stepSum = 0;

        for (int num : nums) {
            stepSum += num;
            minStepSum = Math.min(stepSum, minStepSum);
        }

        if (minStepSum < 1) {
            return Math.abs(minStepSum) + 1;
        } else return 1;
    }
}
