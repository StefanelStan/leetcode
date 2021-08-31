package com.ss.leetcode.august;

public class FindMinInRotatedSortedArray {
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
    public int findMin(int[] nums) {
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
