package com.ss.leetcode.LC2021.september;

public class PowerOfTwo {
    // https://leetcode.com/problems/power-of-two/
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n < 0) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }
}
