package com.ss.leetcode.LC2021.november;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    // https://leetcode.com/problems/maximum-product-of-three-numbers/
    public int maximumProduct(int[] nums) {
        int[] mins = {1001, 1001};
        int[] max = {-1002,-1002,-1002};

        for (int num : nums) {
            injectMin(num, mins);
            injectMax(num, max);
        }

        return Math.max(mins[0] * mins[1] * max[2], max[0] * max[1] * max[2]);
    }

    private void injectMin(int num, int[] mins) {
        if (num <= mins[0]) {
            mins[1] = mins[0];
            mins[0] = num;
        } else if (num < mins[1]) {
            mins[1] = num;
        }
    }

    private void injectMax(int num, int[] max) {
        if (num >= max[2]) {
            max[0] = max[1];
            max[1] = max[2];
            max[2] = num;
        } else if (num >= max[1]) {
            max[0] = max[1];
            max[1] = num;
        } else if (num > max[0]) {
            max[0] = num;
        }
    }

    public int maximumProduct2(int[] nums) {
         Arrays.sort(nums);
         return Math.max(nums[0] * nums[1] * nums[nums.length -1],
                         nums[nums.length -3] * nums[nums.length-2] * nums[nums.length -1]);
    }
}
