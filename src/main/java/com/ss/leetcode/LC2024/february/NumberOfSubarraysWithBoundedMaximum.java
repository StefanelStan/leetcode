package com.ss.leetcode.LC2024.february;

public class NumberOfSubarraysWithBoundedMaximum {
    // https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[][] nextAboveMaxAndAboveMin = getNextOverLimit(nums, left, right);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= right) {
                if (nums[i] < left) { // lesser than min
                    if (nextAboveMaxAndAboveMin[i][0] >= nextAboveMaxAndAboveMin[i][1]) {
                        total += (nextAboveMaxAndAboveMin[i][0] - nextAboveMaxAndAboveMin[i][1]);
                    }
                } else {
                    total += (nextAboveMaxAndAboveMin[i][0] - i);
                }
            }
        }
        return total;
    }

    private int[][] getNextOverLimit(int[] nums, int min, int max) {
        int onRightAboveMax = nums.length;
        int onRightAboveMin = nums.length + 1;
        int[][] nextAboveMaxAndAboveMin = new int[nums.length][2];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                onRightAboveMax = i;
            } else if (nums[i] >= min){
                onRightAboveMin = i;
            }
            nextAboveMaxAndAboveMin[i][0] = onRightAboveMax;
            nextAboveMaxAndAboveMin[i][1] = onRightAboveMin;
        }
        return nextAboveMaxAndAboveMin;
    }
}
