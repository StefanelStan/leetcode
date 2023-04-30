package com.ss.leetcode.LC2020.december;

public class RemoveElement {
    // https://leetcode.com/problems/remove-element
    public int removeElement(int[] nums, int val) {
        int low = 0, high = nums.length -1;
        while(low <= high) {
            while (low <= high && nums[low] != val) {
                low++;
            }
            while (high >= low && nums[high] == val) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                nums[high] = val;
                low++;
                high--;
            }
        }
        return low;
    }

    public int removeElement2(int[] nums, int val) {
        int lastValidPosition = getLastValidPosition(nums, val, nums.length -1);
        for (int i =0; i < lastValidPosition; i++) {
            if(nums[i] == val) {
                nums[i] = nums[lastValidPosition];
                nums[lastValidPosition] = val;
                lastValidPosition = getLastValidPosition(nums, val, lastValidPosition -1);
            }
        }
        for (int i =0; i < nums.length; i++) {
            if(nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    private int getLastValidPosition(int[] nums, int val, int endPosition) {
        for(int i = endPosition; i >= 0; i--) {
            if(nums[i] != val) {
                return i;
            }
        }
        return 0;
    }
}
