package com.ss.leetcode.LC2023.june;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostToMakeArrayEqual {
    // https://leetcode.com/problems/minimum-cost-to-make-array-equal
    public long minCost(int[] nums, int[] cost) {
        int[][] sortedNumsAndCost = getNumsAndCost(nums, cost);
        GroupCost[] groupCost = getGroupCost(sortedNumsAndCost);
        if (groupCost.length == 1) {
            return 0;
        }
        long[][] upperLowerCost = getUpperLowerCost(groupCost);
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < upperLowerCost[0].length; i++) {
            minCost = Math.min(minCost, upperLowerCost[0][i] + upperLowerCost[1][i]);
        }
        return minCost;
    }

    private long[][] getUpperLowerCost(GroupCost[] groupCost) {
        long[][] upperLowerCost =  new long[2][groupCost.length];
        long leftRollingCost = groupCost[0].cost, rightRollingCost = groupCost[groupCost.length - 1].cost;
        for (int i = 1, j = groupCost.length - 2; j >=0; i++, j--) {
            upperLowerCost[0][i] = upperLowerCost[0][i-1] + (groupCost[i].value - groupCost[i-1].value) * leftRollingCost;
            leftRollingCost += groupCost[i].cost;

            upperLowerCost[1][j] = upperLowerCost[1][j + 1] + (groupCost[j+1].value - groupCost[j].value) * rightRollingCost;
            rightRollingCost += groupCost[j].cost;
        }
        return upperLowerCost;
    }

    private GroupCost[] getGroupCost(int[][] sortedNumsAndCost) {
        int uniqueNumbers = 0, prev = -1;
        for (int[] numAndCost : sortedNumsAndCost) {
            if (numAndCost[0] != prev) {
                uniqueNumbers++;
            }
            prev = numAndCost[0];
        }

        GroupCost[] groupCost =  new GroupCost[uniqueNumbers];
        int insertIndex = 0;
        int value = sortedNumsAndCost[0][0];
        long cost = sortedNumsAndCost[0][1];
        for (int i = 1; i < sortedNumsAndCost.length; i++) {
            if (sortedNumsAndCost[i][0] == sortedNumsAndCost[i-1][0]) {
                cost += sortedNumsAndCost[i][1];
            } else {
                groupCost[insertIndex] = new GroupCost(value, cost);
                value = sortedNumsAndCost[i][0];
                cost = sortedNumsAndCost[i][1];
                insertIndex++;
            }
        }
        groupCost[insertIndex] = new GroupCost(value, cost);
        return groupCost;
    }

    private int[][] getNumsAndCost(int[] nums, int[] cost) {
        int[][] numsAndCost = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));
        return numsAndCost;
    }

    private static class GroupCost {
        private final int value;
        private final long cost;

        public GroupCost(int value, long cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
