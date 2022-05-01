package com.ss.leetcode.LC2022.april;

public class MinimumAverageDifference {
    // https://leetcode.com/contest/biweekly-contest-77/problems/minimum-average-difference/
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        long[] leftSum = new long[nums.length];
        leftSum[0] = nums[0];
        long minAvg = Integer.MAX_VALUE;
        int minPos = -1;
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        long tempAvg = 0;
        for (int i = 0; i < nums.length -1; i++) {
            tempAvg = Math.abs(leftSum[i] / (i + 1) - (leftSum[nums.length -1] - leftSum[i]) / (nums.length - 1 - i));
            if (tempAvg < minAvg) {
                minAvg = tempAvg;
                minPos = i;
            }
        }

        tempAvg = Math.abs(leftSum[nums.length -1] / nums.length);
        if (tempAvg < minAvg) {
            minPos = nums.length -1;
        }
        return minPos;
    }
    // 29403
}
