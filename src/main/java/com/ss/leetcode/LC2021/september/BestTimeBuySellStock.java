package com.ss.leetcode.LC2021.september;

public class BestTimeBuySellStock {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = prices[prices.length - 1];
        int maxValue = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxValue - minValue, maxProfit);
            if (prices[i] > maxValue) {
                minValue = prices[i];
                maxValue = prices[i];
            }
        }
        return maxProfit;
    }
}
