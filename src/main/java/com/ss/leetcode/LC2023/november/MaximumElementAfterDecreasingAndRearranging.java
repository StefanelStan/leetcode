package com.ss.leetcode.LC2023.november;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {
    // https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging
    /** Algorithm
        1. Look at the numbers from a sorted order perspective.
        2. The 1st number must be made/lowered to 1
        3. Next one should be made/lowered to 1, but the next number could be 1, so we can't lower it to 2
        4. Thus, the next number should be Math.min(prev + 1, next)
        5. Return arr[n-1];
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i-1] + 1, arr[i]);
        }
        return arr[arr.length - 1];
    }
}
