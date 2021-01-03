package com.ss.leetcode.december;

public class MinimumDeletionCost {
    // https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/

    public int minCost(String string, int[] cost) {
        int totalMinCost = 0;

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                int repeatingChainLength = findRepeatingChainLength(i, string);
                int minCost = findMinCostOfDeletion(i, i + repeatingChainLength - 1, cost);
                totalMinCost += minCost;
                i += (repeatingChainLength -1);
            }
        }
        return totalMinCost;
    }

    private int findRepeatingChainLength(int fromIndex, String string) {
        for (int i = fromIndex +1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(fromIndex)) {
                return i - fromIndex;
            }
        }
        return string.length() - fromIndex;
    }

    private int findMinCostOfDeletion(int from, int end, int[] cost) {
        int sum = 0;
        int max = 0;
        for (int i = from; i <= end; i++) {
            if (cost[i] > max) {
                max = cost[i];
            }
            sum += cost[i];
        }
        return sum - max;
    }

}
