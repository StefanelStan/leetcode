package com.ss.leetcode.september;

public class PowerOfTwo {
    // https://leetcode.com/problems/power-of-two/
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }
}
