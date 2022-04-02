package com.ss.leetcode.LC2022.april;

public class FindTriangularSumOfAnArray {
    // https://leetcode.com/contest/biweekly-contest-75/problems/find-triangular-sum-of-an-array/

    /** Algorithm
     *  1. Traverse the array from i = 0 to length and replace nums[i] with nums[i] + nums[i+1]
     *  2. Deduct 1 from the length with each traversal
     *  3. Return nums[0] when length becomes 1
     */
    public int triangularSum(int[] nums) {
        int length = nums.length;
        while(length > 1) {
            for (int i = 0; i < length -1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            length--;
        }
        return nums[0];
    }
}
