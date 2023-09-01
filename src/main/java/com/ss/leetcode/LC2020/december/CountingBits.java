package com.ss.leetcode.LC2020.december;

public class CountingBits {
    // https://leetcode.com/problems/counting-bits/
    public int[] countBits(int n) {
        int[] bitCount = new int[n+1];
        int currentNumber, currentBits;
        while (n > 0) {
            currentNumber = n;
            currentBits = 0;
            while(currentNumber > 0) {
                currentBits += (currentNumber & 1);
                currentNumber = currentNumber >> 1;
            }
            bitCount[n--] = currentBits;
        }
        return bitCount;
    }

    public int[] countBits2(int num) {
        int[] bitCounts = new int[num + 1];
        bitCounts[0] = 0;
        for (int i = 1; i <= num; i++) {
            bitCounts[i] = Long.bitCount(i);
        }
        return bitCounts;
    }
}
