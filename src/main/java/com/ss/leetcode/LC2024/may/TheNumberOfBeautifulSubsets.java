package com.ss.leetcode.LC2024.may;

import java.util.Arrays;

public class TheNumberOfBeautifulSubsets {
    // https://leetcode.com/problems/the-number-of-beautiful-subsets
    /** Algorithm
        1. Sort the numbers. This way, it's easier to check if an absolute diff exists: we only need to check num[i] - k
        2. Use an int[1001] count to count how many numbers you have present in your selected subset.
        3. Use a recursive function that will pick (only if nums[i] - k is not present) or skip current index
        4. Return the top result.
     */
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return countIndices(0, nums, k, new int[1001]);
    }

    private int countIndices(int index, int[] nums, int k, int[] count) {
        if (index == nums.length) {
            return 0;
        }
        int total = 0;
        if (nums[index] - k < 1 || count[nums[index] - k] == 0) {
            count[nums[index]]++;
            total = 1 + countIndices(index + 1, nums, k, count);
            count[nums[index]]--;
        }
        total += countIndices(index + 1, nums, k, count);
        return total;
    }
}
