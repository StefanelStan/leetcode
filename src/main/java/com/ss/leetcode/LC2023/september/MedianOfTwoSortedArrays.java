package com.ss.leetcode.LC2023.september;

public class MedianOfTwoSortedArrays {
    // https://leetcode.com/problems/median-of-two-sorted-arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int sum = 0;
        int stoppingStep = (nums1.length + nums2.length + 1) / 2;
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        int steps = 0;
        while ((i < nums1.length || j < nums2.length) && steps < stoppingStep) {
            if (i < nums1.length) {
                if (j < nums2.length) {
                    sum = (nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++]);
                } else {
                    sum = nums1[i++];
                }
            } else {
                sum = nums2[j++];
            }
            steps++;
        }
        double median = sum;
        if (isEven) {
            if (i < nums1.length && j < nums2.length) {
                median += Math.min(nums1[i], nums2[j]);
            } else if (i < nums1.length) {
                median += nums1[i];
            } else {
                median += nums2[j];
            }
            return median / 2;
        } else {
            return median;
        }
    }
}
