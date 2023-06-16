package com.ss.leetcode.LC2023.june;

public class NumberOfSmoothDescentPeriodsOfAStock {
    // https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock
    /** Algorithm
        1. Iterate from second to last price, determining if it's a secretse of 1.
            If yes, increase the length of consecutive decreases, Else reset it to 1
        2. Add the length of consecutive decreases to the answer.
        3. Return the answer.
     */
    public long getDescentPeriods(int[] prices) {
        long periods = 1;
        int length = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] != -1) {
                length = 1;
            } else {
                // n * (n+1) / 2 == 1+2+3+..n. We increment length, and we add the length each time.
                // We do 1+2+3..+n each time, rather than once at the end
                length++;
            }
            periods += length;
        }
        return periods;
    }
}
