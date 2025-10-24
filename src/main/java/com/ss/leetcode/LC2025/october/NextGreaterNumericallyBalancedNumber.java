package com.ss.leetcode.LC2025.october;

public class NextGreaterNumericallyBalancedNumber {
    // https://leetcode.com/problems/next-greater-numerically-balanced-number
    /** Algorithm
         1. While the number is not balanced
            - Increment and check if number is balanced
         2. Checking if number is balanced:
            - count the digits and if one count is > 0 but different than the digit value, return false;
     */
    public int nextBeautifulNumber(int n) {
        n++;
        while (!isBalanced(n)) {
            n++;
        }
        return n;
    }

    private boolean isBalanced(int n) {
        int[] digits = new int[10];
        while(n > 0) {
            digits[n % 10]++;
            n = n / 10;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0 && i != digits[i]) {
                return false;
            }
        }
        return true;
    }
}
