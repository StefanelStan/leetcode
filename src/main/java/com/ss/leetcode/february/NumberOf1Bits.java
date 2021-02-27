package com.ss.leetcode.february;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String val = Integer.toBinaryString(n);
        int nrOfOne = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '1') {
                nrOfOne++;
            }
        }
        return nrOfOne;
    }
}
