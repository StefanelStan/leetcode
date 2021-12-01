package com.ss.leetcode.LC2021.may;

public class SubtractProductAndSumDigits {
    // https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public int subtractProductAndSum(int n) {
        String nr = String.valueOf(n);
        int product = 1, sum =0;
        int currentDigit = 0;
        for (int i = 0; i < nr.length(); i++) {
            currentDigit = Integer.parseInt(String.valueOf(nr.charAt(i)));
            product *= currentDigit;
            sum +=  currentDigit;
        }
        return product - sum;
    }
}
