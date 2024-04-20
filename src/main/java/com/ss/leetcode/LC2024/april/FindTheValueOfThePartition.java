package com.ss.leetcode.LC2024.april;

import java.util.Arrays;

public class FindTheValueOfThePartition {
    // https://leetcode.com/problems/find-the-value-of-the-partition
    /** Algorithm
        1. Looking at the requirement of max(nums1) - min(nums2) we realize that we need the max from nums1 to be as close as possible with min from nums2.
        2. This is only possible if we SORT the numbers and we compare two at a time.
        3. Thus, when comparing numbers [a] and [a+1], it is guaranteed that [a] is max of num1 and [a+1] min of nums2.
        4. Sort them and compare each [i] with [i+1], returning their min difference.
     */
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int partitionValue = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length && partitionValue != 0; i++) {
            partitionValue = Math.min(partitionValue, nums[i] - nums[i-1]);
        }
        return partitionValue;
    }
}
