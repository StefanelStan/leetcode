package com.ss.leetcode.LC2025.january;

public class NumberOfBitChangesToMakeTwoIntegersEqual {
    // https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal
    /** Algorithm
        1. Loop while n > 0 OR k > 0
        2. if their last bit is different, return -1 if lastBitOfN is 0, else increment changes (as last bit of n is 1 and last bit of k is 0)
     */
    public int minChanges(int n, int k) {
        int lastNBit, lastKBit;
        int minChanges = 0;
        while (n > 0 || k > 0) {
            lastNBit = (n & 1);
            lastKBit = (k & 1);
            if (lastNBit != lastKBit) {
                if (lastNBit == 0) {
                    return -1;
                } else {
                    minChanges++;
                }
            }
            n = n >> 1;
            k = k >> 1;
        }
        return minChanges;
    }
}
