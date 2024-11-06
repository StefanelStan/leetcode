package com.ss.leetcode.LC2024.november;

public class FindIfArrayCanBeSorted {
    // https://leetcode.com/problems/find-if-array-can-be-sorted
    /** Algorithm
        1. Implement Bubble Sort
        2. Loop from 0 ro n- 2 ; if current num > next
            - if they have same bits, swap them
            - else return false, as you cannot sort this ASC
        3. Break when no swapping has been made, so the array is fully sorted.
     */
    public boolean canSortArray(int[] nums) {
        boolean changed = true;
        int temp;
        while(changed) {
            changed = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i+1]) {
                    if (Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])) {
                        temp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = temp;
                        changed = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
