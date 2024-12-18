package com.ss.leetcode.LC2021.august;

import java.util.LinkedList;

public class FinalPricesWithSpecialDiscount {
    // https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i + 1; j < prices.length; j++){
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    // Next Lower Element - Monotonic Stack
    public int[] finalPrices2(int[] prices) {
        int[] finalPrices = new int[prices.length];
        LinkedList<Integer> higherPrices = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            finalPrices[i] = prices[i];
            while (!higherPrices.isEmpty() && finalPrices[higherPrices.peekLast()] >= prices[i]) {
                finalPrices[higherPrices.removeLast()] -= prices[i];
            }
            higherPrices.addLast(i);
        }
        return finalPrices;
    }
}
