package com.ss.leetcode.LC2021.july;

public class FibonacciNumber {
    // https://leetcode.com/problems/fibonacci-number/
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int current = 1, prev  = 0;
        for (int i = 2; i <= n; i++) {
            current = current + prev;
            prev = current - prev;
        }
        return current;
    }
}
