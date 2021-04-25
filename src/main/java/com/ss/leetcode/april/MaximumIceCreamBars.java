package com.ss.leetcode.april;

import java.util.Arrays;

public class MaximumIceCreamBars {
    // https://leetcode.com/problems/maximum-ice-cream-bars/
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int steps = 0;
        for (int cost : costs) {
            coins -= cost;
            steps++;
            if (coins < 0) {
                return steps -1;
            }
        }
        return steps;
    }
}
