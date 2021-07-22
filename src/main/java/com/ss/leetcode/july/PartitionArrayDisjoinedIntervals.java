package com.ss.leetcode.july;

public class PartitionArrayDisjoinedIntervals {
    // https://leetcode.com/problems/partition-array-into-disjoint-intervals/
    public int partitionDisjoint(int[] nums) {
        // Determine and memoize the maxValue of left side and minValue of left side; also, find the pivot of first minValue
        int[] maxIndexes = new int[nums.length];
        int[] minIndexes = new int[nums.length];
        int minValue = nums[0], minValueIndex = 0;
        maxIndexes[0] = nums[0];
        minIndexes[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            maxIndexes[i] = Math.max(nums[i], maxIndexes[i - 1]);
            minIndexes[j] = Math.min(nums[j], minIndexes[j + 1]);
            if (minValue > nums[i]) {
                minValue = nums[i];
                minValueIndex = i;
            }
        }
        // From the pivot start looking into right side for the condition maxLeft <= minRight
        for(int i = minValueIndex; i < nums.length - 1; i++) {
            if (maxIndexes[i] <= minIndexes[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
