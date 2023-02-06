package com.ss.leetcode.LC2023.february;

public class MinimumCommonValue {
    // https://leetcode.com/problems/minimum-common-value
    /** Algorithm
        1. Use 2 pointers: i and j for nums1 and nums2;
        2. Iterate with the two pointers over nums1 and nums2 while i < nums1.l and j < nums2.l
        3. If nums1[i] == nums2[j] , then you found the first number
            If nums1[i] < nums2[j], you have to advance i
            else advance j
        4. This algorithm will always try to advance the minimum between the two points in order to find the equal value.
     */
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
