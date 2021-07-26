package com.ss.leetcode.july;

public class PowXN {
    // https://leetcode.com/problems/powx-n/
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0) return 1;

        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;
    }
}
