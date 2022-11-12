package com.ss.leetcode.LC2022.november;

import java.util.Arrays;

public class NumberOfDistinctAverages {
    // https://leetcode.com/problems/number-of-distinct-averages
    /** Algorithm
        1. Sort the numbers and to use 2 points: left(0), right(n).
        2. You don't need to calculate the average but simply mark the sums of left and right.
           (1 and 7 will have the same average as 3 + 5; the only thing that matters is the sum of the two)
        3. Mark/store the sums of left/right in an array of type boolean[201].
           If sums[left+right] == false, then this average is unique. Count it and mark it with true.
        4. Return the number of unique sums (which will lead to unique averages)
     */
    public int distinctAverages(int[] nums) {
        boolean[] sums =  new boolean[201];
        int distinct = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length -1; i < j; i++, j--) {
            if (!sums[nums[i] + nums[j]]) {
                distinct++;
            }
            sums[nums[i] + nums[j]] = true;
        }
        return distinct;
    }
}
