package com.ss.leetcode.LC2021.november;

public class MinimumCostHomeComingOfARobotInAGrid {
    // https://leetcode.com/contest/biweekly-contest-66/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int rowCost = getWalkCost(startPos[0], homePos[0], rowCosts);
        int colCost = getWalkCost(startPos[1], homePos[1], colCosts);
        return rowCost + colCost;
    }

    private int getWalkCost(int start, int dest, int[] costs) {
        int cost = 0;
        if (start != dest) {
            int direction = start < dest ? 1 : -1;
            for (int i = start + direction;; i += direction) {
                cost += costs[i];
                if (i == dest) {
                    break;
                }
            }
        }
        return cost;
    }
}
