package com.ss.leetcode.march;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int maxCoins = 0;
        for (int position = piles.length - 2; position >= piles.length / 3; position -= 2) {
            maxCoins += piles[position];
        }
        return maxCoins;
    }
}
