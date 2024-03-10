package com.ss.leetcode.LC2024.march;

public class MaximizeTheTopmostElementAfterKMoves {
    // https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves
    /** Algorithm
        1. Deal with edge cases:
            - if nums.length == 1, you CANNOT have a topelement if k % 2 == 0; else it's nums[0]
            - if k == 1, you can only make 1 move: remove top element.So topmost = nums[1]
        2. Traverse array and while k > 1, keep track of max number. Stop when k == 1.
            - The logic is IF  k > nums.length, then you can have the highest number from array on the pile
        3. If k ==1 (you stopped before the array ended AND you are NOT at the end of array, then you still have 1 move.
            - If next element on pile nums[i+1] > highest, then we want to remove to access it
            - Else, we will keep the highest encountered so far.
     */
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            return k % 2 == 1 ? -1 : nums[0];
        }
        if (k == 1) {
            return nums[1];
        }
        int maxSoFar = nums[0];
        int i = 0;
        for (; i < nums.length && k > 1; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            k--;
        }
        // 1 more move left: is next higher than what we encounterd so far or not?
        if (k == 1 && i < nums.length - 1) {
            return Math.max(maxSoFar, nums[i+1]);
        }
        return maxSoFar;
    }
}
