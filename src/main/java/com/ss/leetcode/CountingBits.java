package com.ss.leetcode;


import java.util.HashMap;
import java.util.Map;

public class CountingBits {
    // https://leetcode.com/problems/counting-bits/
    public int[] countBits(int num) {
        int[] bitCounts = new int[num + 1];
        bitCounts[0] = 0;
        for (int i = 1; i <= num; i++) {
            bitCounts[i] = Long.bitCount(i);
        }
        return bitCounts;
    }
}
