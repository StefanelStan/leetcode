package com.ss.leetcode.LC2024.september;

import java.util.List;

public class MaximumNumberOfAlloys {
    // https://leetcode.com/problems/maximum-number-of-alloys
    /** Algorithm
        1. Each machine can build a max number of alloys, based on cost and stock, so find the max number for each machine.
        2. You can't iterate with i from 1 to infinity and find if a machine can build i, i+1 alloys etc
        3. Use a binary search to find out the best number of alloys each machine can build
            - EG: low = 1, high = 500_000_000.
            - can machine1 build 250 mil alloys? No, then 125? Yes? Then 185 (binary search)
            - for each targetted number, multiply the target number with composition - stock multiplied by the cost.
            - check if the cost of building targetNumber of alloys goes over the budget.
     */
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int maxAlloys = -1;
        for (List<Integer> needed : composition) {
            maxAlloys = Math.max(maxAlloys, buildMax(needed, stock, cost, budget));
        }
        return maxAlloys;
    }

    private int buildMax(List<Integer> composition, List<Integer> stock, List<Integer> cost, long budget) {
        int low = 1, high = 500_000_000, pivot;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if (canBuildUnits(pivot, composition, stock, cost, budget)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private boolean canBuildUnits(long units, List<Integer> composition, List<Integer> stock, List<Integer> cost, long budget) {
        long estimatedCost = 0L;
        for (int i = 0; i < composition.size() && estimatedCost <= budget; i++) {
            estimatedCost += (units * composition.get(i) > stock.get(i) ? (units * composition.get(i) - stock.get(i)) * cost.get(i)  : 0);
        }
        return budget >= estimatedCost;
    }
}
