package com.ss.leetcode.LC2020.december;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int orderedNumbers = 1;
        int swapsMade = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                int nextHigherIndex = getNextHigherIndex(nums, i);
                if(nextHigherIndex == nums.length) {
                    break;
                }
                nums[i] = nums[nextHigherIndex];
                orderedNumbers++;
                swapsMade++;
            } else {
                orderedNumbers++;
            }
        }
        return orderedNumbers;
    }

    private int getNextHigherIndex(int[] nums, int startIndex) {
        for(int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[startIndex -1]) {
                return i;
            }
        }
        return nums.length;
    }
}
