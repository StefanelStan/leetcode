package com.ss.leetcode.LC2024.december;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {
    // https://leetcode.com/problems/maximum-tastiness-of-candy-basket
    /** Algorithm
        1. Sort the prices.
        2. Using binary search (0, 10^9) try to find the maximum tastiness
        3. Finding tastiness
            - You need to find the answer: can I select k candies that have a difference of "pivot" between them?
            - Traverse the sorted prices and if price[i] - prev >= k,select that price and subtract k. Return k == 0
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = 1_000_000_000, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canMakeKBaskets(price, pivot, k)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private boolean canMakeKBaskets(int[] price, int distance, int k) {
        k -= 1;
        int prev = price[0];
        for (int i = 1; i < price.length && k > 0; i++) {
            if (price[i] - prev >= distance) {
                k--;
                prev = price[i];
            }
        }
        return k == 0;
    }
}
