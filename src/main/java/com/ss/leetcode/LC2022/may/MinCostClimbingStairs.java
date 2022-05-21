package com.ss.leetcode.LC2022.may;

public class MinCostClimbingStairs {
    // https://leetcode.com/problems/min-cost-climbing-stairs/
    public int minCostClimbingStairs(int[] cost) {
        int minusTwoCost = cost[0];
        int minusOneCost = cost[1];
        int currentCost;
        for (int i = 2; i < cost.length; i++) {
            currentCost = Math.min(minusTwoCost, minusOneCost) + cost[i];
            minusTwoCost = minusOneCost;
            minusOneCost = currentCost;
        }
        return Math.min(minusTwoCost, minusOneCost);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int[] climbingCost = new int[cost.length];
        climbingCost[0] = cost[0];
        climbingCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            climbingCost[i] = Math.min(climbingCost[i-1], climbingCost[i-2])  + cost[i];
        }
        return Math.min(climbingCost[cost.length -1], climbingCost[cost.length -2]);
    }
}
