package com.ss.leetcode.LC2021.july;

public class SearchInsertPosition {
    // https://leetcode.com/problems/search-insert-position/
    // PRO VERSION!
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        int pivot = 0;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if (target == nums[pivot]) {
                return pivot;
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int position = 0;
        if (target <= nums[0]) {
            return position;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if(target == nums[nums.length - 1]) {
            return nums.length -1;
        }
        int left = 0, right = nums.length -1;
        int pivot = 0;
        while(true) {
            if (right - left == 1) {
                return right;
            }
            pivot = nums[left +  (right - left) / 2];
            if (target == pivot) {
                return left + (right - left) / 2;
            } else if (target < pivot) {
                right = left +  (right - left) / 2;
            } else {
                left = left +  (right - left) / 2;
            }
        }
    }
}

