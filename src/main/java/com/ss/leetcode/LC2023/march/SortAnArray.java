package com.ss.leetcode.LC2023.march;

public class SortAnArray {
    // https://leetcode.com/problems/sort-an-array
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length -1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        int low = start, high = end, temp;
        int pivot = nums[low + (high - low) / 2];
        while(low <=  high) {
            while(nums[high] > pivot) {
                high--;
            }
            while(nums[low] < pivot) {
                low++;
            }
            if(low <= high) {
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        if (high > start) {
            quickSort(nums, start, high);
        }
        if (low < end) {
            quickSort(nums, low, end);
        }
    }
}
