package com.ss.leetcode.LC2022.april;

public class MinimumAverageDifference {
    // https://leetcode.com/contest/biweekly-contest-77/problems/minimum-average-difference/
    // No need to cache the partialSums. Just get totalSum and compute partialSum/ & avg at each step
    // right sum is totalSum - partialSum.
    public int minimumAverageDifference(int[] nums) {
        int minAvg = Integer.MAX_VALUE, minAvgPos = -1, rightAverage, currentAvg;
        long totalSum = 0, partialSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            partialSum += nums[i];
            currentAvg = (int)(partialSum / (i + 1));
            rightAverage = i == nums.length-1 ? 0 : (int)((totalSum - partialSum) / (nums.length - (i + 1)));
            if (minAvg > Math.abs(currentAvg - rightAverage)) {
                minAvg = Math.abs(currentAvg - rightAverage);
                minAvgPos = i;
            }
        }
        return minAvgPos;
    }


    public int minimumAverageDifference2(int[] nums) {
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
