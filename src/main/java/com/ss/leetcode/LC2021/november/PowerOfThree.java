package com.ss.leetcode.LC2021.november;

public class PowerOfThree {
    // https://leetcode.com/problems/power-of-three/
    public boolean isPowerOfThree(int n) {
        int remainder = 0;
        if (n <= 0) return false;
        while (n > 1 && remainder == 0) {
            remainder = n % 3;
            n = n / 3;
        }
        return remainder == 0;
    }
}
