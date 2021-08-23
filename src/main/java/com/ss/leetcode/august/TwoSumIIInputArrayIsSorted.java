package com.ss.leetcode.august;

public class TwoSumIIInputArrayIsSorted {
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int tempSum;
        while (low < high) {
            tempSum = numbers[low] + numbers[high];
            if (tempSum > target) {
                high--;
            } else if (tempSum < target) {
                low++;
            } else {
                return new int[] { low + 1, high + 1 };
            }
        }
        return new int[] { 0, 0 };
    }
}
