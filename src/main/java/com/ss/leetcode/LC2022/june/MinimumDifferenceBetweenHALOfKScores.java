package com.ss.leetcode.LC2022.june;

import java.util.Arrays;

public class MinimumDifferenceBetweenHALOfKScores {
    // https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
    /** Algorithm
         1. In order to determine the minimum difference between min/max in a window of k size,
            the numbers have to be picked in a way that the min is as close as possible to max,
            This means the rest of the numbers from that window are somewhere between min and max of that window.
         2. Analyzing this, the only way to assure this is to sort the numbers and pick the window in order from 1st to last-k element.
         3. Sort the numbers and determine the min between all [i, i+k] for elements starting from 0 to n-k index
     */
    public int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - k && min != 0; i++) {
            // if min reaches 0, then the loop has to stop and no other number lower than 0 can be found.
            min = Math.min(min, nums[i + k -1] - nums[i]);
        }
        return min;
    }
}
