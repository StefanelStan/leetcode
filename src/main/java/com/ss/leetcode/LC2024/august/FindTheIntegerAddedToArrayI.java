package com.ss.leetcode.LC2024.august;

public class FindTheIntegerAddedToArrayI {
    // https://leetcode.com/problems/find-the-integer-added-to-array-i
    /** Algorithm
        1. Traverse nums1 and nums2 and find min1 (nums1 min) and min2 (nums2 min).
        2. Return the difference between min2 and min1.
     */
    public int addedInteger(int[] nums1, int[] nums2) {
        int nums1Min = Integer.MAX_VALUE, nums2Min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            nums1Min = Math.min(nums1Min, nums1[i]);
            nums2Min = Math.min(nums2Min, nums2[i]);
        }
        return nums2Min - nums1Min;
    }
}
