package com.ss.leetcode.LC2025.january;

public class FindCommonElementsBetweenTwoArrays {
    // https://leetcode.com/problems/find-common-elements-between-two-arrays
    /** Algorithm
        1. Use 2 x int[101] count1, count2 to store the count of the numbers from num1, nums2
        2. Traverse with i from 1 to 100 and if count1[i] > 0 && count2[i] > 0, add count1[i] to c1 and count2[i] to c2.
        3. Return int[c1, c2];
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] nums1Count = countNums(nums1);
        int[] nums2Count = countNums(nums2);
        int[] intersection = {0,0};
        for (int i = 0; i < nums1Count.length; i++) {
            if (nums1Count[i] > 0 && nums2Count[i] > 0) {
                intersection[0] += nums1Count[i];
                intersection[1] += nums2Count[i];
            }
        }
        return intersection;
    }

    private int[] countNums(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        return count;
    }
}
