package com.ss.leetcode.LC2021.august;

public class BinarySearch {
    // https://leetcode.com/problems/binary-search/
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length -1;
        int pivot;
        while (low <= high) {
            pivot = low + (high - low) /2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                high = pivot -1;
            } else {
                low = pivot +1;
            }
        }
        return -1;
    }
}
