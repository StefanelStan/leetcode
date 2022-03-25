package com.ss.leetcode.LC2022.march;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    // https://leetcode.com/problems/two-city-scheduling/
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> Math.abs(a[0] - a[1])));
        int p = costs.length / 2;
        int minCost = 0;
        int aCity = 0, bCity = 0;
        for (int i = costs.length - 1; i>= 0; i--) {
            if (aCity == p) {
                minCost += costs[i][1];
            } else if (bCity == p){
                minCost += costs[i][0];
            } else {
                if (costs[i][0] < costs[i][1]) {
                    minCost += costs[i][0];
                    aCity++;
                } else if (costs[i][0] > costs[i][1]) {
                    minCost += costs[i][1];
                    bCity++;
                } else {
                    minCost += costs[i][0];
                }
            }
        }
        return minCost;
    }
}
