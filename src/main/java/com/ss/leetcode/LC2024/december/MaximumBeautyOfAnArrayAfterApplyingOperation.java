package com.ss.leetcode.LC2024.december;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    // https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation
    /** Algorithm
        1. As you need a subsequence, the order is not important -> Sort the number
        2. Sliding window: for a subarray to be valid, it needs nums[left] >= nums[right] - 2 * k.
            - Reduce the window while the condition is not valid
        3. Set length to be max between length and window width.
     */
    public int maximumBeauty(int[] nums, int k) {
        int length = 0;
        Arrays.sort(nums);
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (nums[left] < nums[right] - 2 * k) {
                left++;
            }
            length = Math.max(length, 1 + right - left);
        }
        return length;
    }
}
