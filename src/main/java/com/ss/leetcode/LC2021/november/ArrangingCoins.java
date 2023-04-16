package com.ss.leetcode.LC2021.november;

public class ArrangingCoins {
    // https://leetcode.com/problems/arranging-coins/
    // Binary Search solution!
    public int arrangeCoins(int n) {
        long gathered;
        int low = 1, high = Math.max(1, n - 1), pivot = 1;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            gathered = ((long)pivot * (pivot + 1)) / 2;
            if (gathered > n) {
                high = pivot - 1;
            } else if (gathered < n) {
                low = pivot + 1;
            } else {
                return pivot;
            }
        }
        return high;
    }

    public int arrangeCoins2(int n) {
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
