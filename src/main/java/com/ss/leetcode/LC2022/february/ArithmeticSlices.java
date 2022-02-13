package com.ss.leetcode.LC2022.february;

public class ArithmeticSlices {
    // https://leetcode.com/problems/arithmetic-slices/
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int slices = 0;
        int diff = nums[1] - nums[0];
        int start = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != diff) {
                if (i - start > 2) {
                    slices += getNrOfSubarrays(i - start);
                }
                start = i-1;
                diff = nums[i] - nums[i-1];
            }
        }
        if (start <= nums.length - 3) {
            slices += getNrOfSubarrays(nums.length - start);
        }
        return slices;
    }

    private int getNrOfSubarrays(int length) {
        int trees = length - 2;
        return (trees * (trees + 1)) / 2;
    }
}
