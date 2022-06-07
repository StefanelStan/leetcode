package com.ss.leetcode.LC2021.february;

public class MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            if (m == 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
            } else {
                mergeArrays(nums1, m - 1, nums2, n - 1);
            }
        }
    }

    private void mergeArrays(int[] nums1, int i, int[] nums2, int j) {
        for(int index = nums1.length -1; j>= 0 && index >= 0; index--) {
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            if (i < 0) {
                System.arraycopy(nums2, 0, nums1, 0, j+1);
                break;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
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
