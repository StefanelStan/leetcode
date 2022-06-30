package com.ss.leetcode.LC2022.june;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
    public int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        long minMoves = Integer.MAX_VALUE;
        long stepMoves;
        long[] sum = sortAndGetCumulativeSum(nums);
        long leftSum, rightSum, expectedLeftSum, expectedRightSum;
        int i = 0, j = 0;
        while(i < nums.length) {
            while(j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            j--;
            //do math here
            leftSum = i == 0 ? 0 : sum[i-1];
            rightSum = j == nums.length -1 ? 0 : sum[nums.length -1] - sum[j];
            expectedLeftSum = i == 0 ? 0 : ((long) i * nums[i]);
            expectedRightSum = j == nums.length -1 ? 0 : ((long) (nums.length - j - 1) * nums[i]);
            stepMoves = Math.abs(expectedLeftSum - leftSum) + Math.abs(expectedRightSum - rightSum);
            minMoves = Math.min(minMoves, stepMoves);
            j++;
            i = j;
        }
        return (int)minMoves;
    }

    private long[] sortAndGetCumulativeSum(int[] nums) {
        Arrays.sort(nums);
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        return sum;
    }
}
