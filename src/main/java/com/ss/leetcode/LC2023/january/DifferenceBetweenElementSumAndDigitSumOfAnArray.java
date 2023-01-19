package com.ss.leetcode.LC2023.january;

public class DifferenceBetweenElementSumAndDigitSumOfAnArray {
    // https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array
    /** Algorithm
        1. Traverse the nums and add that number or its digit sum to elementSum or digitSum.
        2. Determine the digitSum by diving the num by 10 and adding its modulo % 10 while nr > 0.
        3. Return the absolute difference between these two.
     */
    public int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;
        for (int num : nums) {
            elementSum += num;
            digitSum += getDigitSum(num);
        }
        return Math.abs(elementSum - digitSum);
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
