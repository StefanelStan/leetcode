package com.ss.leetcode.LC2021.may;

public class SubtractProductAndSumDigits {
    // https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0, digit;
        while(n > 0) {
            digit = n % 10;
            product *= digit;
            sum += digit;
            n = n/10;
        }
        return product - sum;
    }

    public int subtractProductAndSum2(int n) {
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
