package com.ss.leetcode.LC2021.february;

public class MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m < 0) {
                System.arraycopy(nums2, 0, nums1, 0, n+1);
                break;
            } else if (n < 0) {
                break;
            } else {
                if (nums2[n] >= nums1[m]) {
                    nums1[i] = nums2[n];
                    n--;
                } else {
                    nums1[i] = nums1[m];
                    nums1[m] = Integer.MIN_VALUE;
                    m--;
                }
            }
        }
    }
}
