package com.ss.leetcode.LC2021.august;

public class FindMinInRotatedSortedArray {
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
    // PRO binary search
    public int findMin(int[] nums) {
        int min = 5001;
        int low = 0, high = nums.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[low] <= nums[pivot]) {
                min = Math.min(min, nums[low]);
                low = pivot + 1;
            } else {
                min = Math.min(min, nums[pivot + 1]);
                high = pivot;
            }
        }
        return min;
    }

    public int findMin2(int[] nums) {
        return findMinArray(nums, 0, nums.length-1);
    }

    private int findMinArray(int[] nums, int low, int high) {
        if (high - low < 2) {
            return Math.min(nums[low], nums[high]);
        }
        int pivot = low + (high - low) /2;
        // check sequences;
        boolean leftSorted = nums[low] < nums[pivot];
        boolean rightSorted = nums[high] > nums[pivot];
        // check lucky interval case;
        if (leftSorted && rightSorted) {
            return nums[low];
        }

        if (!leftSorted && !rightSorted) {
            return nums[high];
        }

        if (leftSorted) {
            if (nums[pivot] > nums[pivot +1]) {
                return nums[pivot + 1];
            }
            return findMinArray(nums, pivot +1, high);
        }

        if (nums[pivot] < nums[pivot - 1]) {
            return nums[pivot];
        }
        return findMinArray(nums, low, pivot - 1);
    }
}
