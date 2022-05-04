package com.ss.leetcode.LC2022.may;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    // https://leetcode.com/problems/max-number-of-k-sum-pairs/
    public int maxOperations(int[] nums, int k) {
        int maxOperations = 0;
        if (nums.length == 1) {
            return maxOperations;
        }
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if (nums[low] + nums[high] > k) {
                high--;
            } else if (nums[low] + nums[high] < k) {
                low++;
            } else {
                low++;
                high--;
                maxOperations++;
            }
        }
        return maxOperations;
    }
}
