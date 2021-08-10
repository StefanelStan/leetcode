package com.ss.leetcode.august;

public class SquaresOfASortedArray {
    // https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        int low = 0, high = nums.length -1;
        int[] result = new int[nums.length];
        int backInsertIndex = nums.length -1;
        int leftSquare =0, rightSquare = 0;
        while(backInsertIndex >= 0) {
            leftSquare = nums[low] * nums[low];
            rightSquare = nums[high] * nums[high];
            if (leftSquare >= rightSquare) {
                result[backInsertIndex--] = leftSquare;
                low++;
            } else {
                result[backInsertIndex--] = rightSquare;
                high--;
            }
        }
        return result;
    }
}
