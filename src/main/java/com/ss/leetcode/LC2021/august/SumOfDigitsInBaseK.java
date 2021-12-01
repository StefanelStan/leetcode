package com.ss.leetcode.LC2021.august;

public class SumOfDigitsInBaseK {
    // https://leetcode.com/problems/sum-of-digits-in-base-k/
    public int sumBase(int n, int k) {
        String chars = Integer.toString(n, k);
        int sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            sum += chars.charAt(i) - '0';
        }
        return sum;
    }
}
