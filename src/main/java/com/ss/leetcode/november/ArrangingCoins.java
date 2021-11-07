package com.ss.leetcode.november;

public class ArrangingCoins {
    // https://leetcode.com/problems/arranging-coins/
    public int arrangeCoins(int n) {
        int nrOfStairs = 0;
        long coinsSoFar = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (coinsSoFar + i > n) {
                return nrOfStairs;
            } else {
                coinsSoFar += i;
                nrOfStairs++;
            }
        }
        return nrOfStairs;
    }
}
