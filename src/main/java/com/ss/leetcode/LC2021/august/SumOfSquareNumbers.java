package com.ss.leetcode.LC2021.august;

public class SumOfSquareNumbers {
    // https://leetcode.com/problems/sum-of-square-numbers/
    public boolean judgeSquareSum(int c) {
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
