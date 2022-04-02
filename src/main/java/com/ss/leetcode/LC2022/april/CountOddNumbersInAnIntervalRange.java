package com.ss.leetcode.LC2022.april;

public class CountOddNumbersInAnIntervalRange {
    // https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
    public int countOdds(int low, int high) {
        int odds = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            odds++;
        }
        return odds;
    }
}
