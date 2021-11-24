package com.ss.leetcode.november;

import java.util.HashSet;
import java.util.Set;

public class PowerOfFour {
    // https://leetcode.com/problems/power-of-four/
    Set<Integer> fourPower;
    public boolean isPowerOfFour(int n) {
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
