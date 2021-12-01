package com.ss.leetcode.LC2021.january;

import java.util.Arrays;

public class CoinExchange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] cache = new int[max];
        Arrays.fill(cache, max);
        cache[0] = 0;
        for(int i = 1; i < max; i++) {
            for(int coin : coins) {
                if (coin <= i) {
                    cache[i] =Math.min(cache[i], cache[i - coin] + 1);
                }
            }
        }
        return cache[amount] > amount ? -1 : cache[amount];
    }
}
