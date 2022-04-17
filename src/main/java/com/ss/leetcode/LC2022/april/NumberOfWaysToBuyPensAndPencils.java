package com.ss.leetcode.LC2022.april;

public class NumberOfWaysToBuyPensAndPencils {
    // https://leetcode.com/contest/biweekly-contest-76/problems/number-of-ways-to-buy-pens-and-pencils/
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < Math.min(cost1, cost2)) {
            return 1;
        }
        long ways = 0;
        int minCost = Math.min(cost1, cost2);
        int maxCost = Math.max(cost1, cost2);
        int partialCost = 0;
        while(partialCost <= total) {
            ways += ((total - partialCost) / minCost) + 1;
            partialCost += maxCost;
        }
        return ways;
    }
}
