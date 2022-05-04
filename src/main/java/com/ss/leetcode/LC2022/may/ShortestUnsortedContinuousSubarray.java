package com.ss.leetcode.LC2022.may;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int low = 0, high = nums.length -1;
        while(low < high && copy[low] == nums[low]) {
            low++;
        }
        while(low < high && copy[high] == nums[high]) {
            high--;
        }
        return high <= low ? 0 : (high - low) + 1;
    }
}
