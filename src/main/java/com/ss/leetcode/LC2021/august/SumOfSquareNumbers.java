package com.ss.leetcode.LC2021.august;

public class SumOfSquareNumbers {
    // https://leetcode.com/problems/sum-of-square-numbers/
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c), squareSum = 0;
        while (left <= right) {
            squareSum = (left * left) + (right * right);
            if (squareSum == c) {
                return true;
            } else if (squareSum < 0 || squareSum > c) {
                right --;
            } else {
                left++;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);
        long tempSum;
        while(low <= high) {
            tempSum = low * low + high * high;
            if (tempSum > (long) c) {
                high--;
            } else if (tempSum < (long) c) {
                low++;
            } else return true;
        }
        return false;
    }
}
