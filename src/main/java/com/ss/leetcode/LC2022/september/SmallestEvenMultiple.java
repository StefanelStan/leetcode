package com.ss.leetcode.LC2022.september;

public class SmallestEvenMultiple {
    // https://leetcode.com/problems/smallest-even-multiple/
    /** Algorithm
     1. If n is even, then n itself is the smallest multiple (eg: 8 -> 8 divides 2 and 8 itself)
     2. If n is odd, then the smallest multiple is 2 * n. (eg: 7 - > 7 divides 7 but not 2, so the smalles multiple is 7 * 2).
     */
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return n * 2;
        }
    }
}
