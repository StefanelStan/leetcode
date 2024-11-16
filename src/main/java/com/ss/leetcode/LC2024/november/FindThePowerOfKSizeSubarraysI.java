package com.ss.leetcode.LC2024.november;

import java.util.Arrays;

public class FindThePowerOfKSizeSubarraysI {
    // https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i
    /** Algorithm
        1. Fail fast: if k == 1 return nums
        2. Use an int[] powerOfK to store the result. Prefill it with -1
        3. Traverse nums and keep track of current "valid window size". If nums[i] - nums[i-1] == 1, increment window size.
        4. If window size == k, set powerOfK[1 + i - k] = nums[i] and reduce window by 1
        5. If current is not consecutive, reset window size to 1 (current number).
     */
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] powerOfK =  new int[1 + nums.length - k];
        Arrays.fill(powerOfK, -1);
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                size++;
                if (size == k) {
                    powerOfK[1 + i - k] = nums[i];
                    size--;
                }
            } else {
                size = 1;
            }
        }
        return powerOfK;
    }
}
