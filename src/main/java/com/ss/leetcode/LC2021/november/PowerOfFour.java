package com.ss.leetcode.LC2021.november;

import java.util.HashSet;
import java.util.Set;

public class PowerOfFour {
    // https://leetcode.com/problems/power-of-four/
    public boolean isPowerOfFour(int n) {
        while (n >= 4 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    Set<Integer> fourPower;
    public boolean isPowerOfFour2(int n) {
        setFourPower();
        return fourPower.contains(n);
    }

    private void setFourPower() {
        if (fourPower == null) {
            fourPower = new HashSet<>();
            long val = 1;
            while (val <= Integer.MAX_VALUE) {
                fourPower.add((int)val);
                val *= 4;
            }
        }
    }
}
