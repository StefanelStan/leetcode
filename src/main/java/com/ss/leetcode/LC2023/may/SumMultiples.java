package com.ss.leetcode.LC2023.may;

public class SumMultiples {
    // https://leetcode.com/problems/sum-multiples
    public int sumOfMultiples(int n) {
        if (n <= 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
