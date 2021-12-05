package com.ss.leetcode.LC2021.december;

public class PerfectNumber {
    // https://leetcode.com/problems/perfect-number/
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int divisorSum = 1;
        int limit = (int)Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                divisorSum += (num / i + i);
            }
        }
        return divisorSum == num;
    }
}
