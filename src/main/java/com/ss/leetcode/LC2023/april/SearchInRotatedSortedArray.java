package com.ss.leetcode.LC2023.april;

public class SearchInRotatedSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1, pivot;
        boolean leftSorted;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            leftSorted = nums[low] <= nums[pivot];
            if (leftSorted) {
                if (nums[low] <= target && nums[pivot] > target) {
                    high = pivot - 1;
                } else {
                    low = pivot + 1;
                }
            } else {
                if (nums[high] >= target && nums[pivot] < target) {
                    low = pivot + 1;
                } else {
                    high = pivot - 1;
                }
            }
        }
        return -1;
    }
}
