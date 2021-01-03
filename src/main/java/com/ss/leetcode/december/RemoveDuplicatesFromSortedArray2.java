package com.ss.leetcode.december;

public class RemoveDuplicatesFromSortedArray2 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int orderedNumbers = 1;
        boolean oneDuplicateFound = false;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!oneDuplicateFound) {
                    oneDuplicateFound = true;
                    orderedNumbers++;
                } else {
                    int nextHigherIndex = getNextHigherIndex(nums, i);
                    if (nextHigherIndex == nums.length) {
                        break;
                    }
                    temp = nums[i];
                    nums[i] = nums[nextHigherIndex];
                    nums[nextHigherIndex] = temp;
                    orderedNumbers++;
                    oneDuplicateFound = false;
                }
            } else {
                oneDuplicateFound = false;
                if (nums[i] < nums[i - 1]) {
                    int nextHigherIndex = getNextHigherIndex(nums, i);
                    if (nextHigherIndex == nums.length) {
                        break;
                    }
                    temp = nums[i];
                    nums[i] = nums[nextHigherIndex];
                    nums[nextHigherIndex] = temp;
                    orderedNumbers++;
                } else {
                    orderedNumbers++;
                }
            }
        }
        return orderedNumbers;
    }

    private int getNextHigherIndex(int[] nums, int startIndex) {
        for (int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] == nums[startIndex - 1] && nums[i] != nums[startIndex -2]) {
                return i;
            }
            if (nums[i] > nums[startIndex - 1]) {
                return i;
            }
        }
        return nums.length;
    }
}
