package com.ss.leetcode.LC2025.october;

public class SmallestNumberWithAllSetBits {
    // https://leetcode.com/problems/smallest-number-with-all-set-bits
    /** Algorithm
        1. Set smallest to 0
        2. While smallest < n, multiple smallest by 2 and add 1. This simulates adding a bit of 1 at the end of smallest.
     */
    public int smallestNumber(int n) {
        int smallest = 0;
        while (smallest < n) {
            smallest = smallest * 2 + 1;
        }
        return smallest;
    }
}
