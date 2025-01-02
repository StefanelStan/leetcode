package com.ss.leetcode.LC2025.january;

import java.util.Arrays;

public class MaximumTotalRewardUsingOperationsI {
    // https://leetcode.com/problems/maximum-total-reward-using-operations-i
    public int maxTotalReward(int[] rewardValues) {
        int[] present = getPresentValues(rewardValues);
        int[][] maxReward = new int[present.length][present[present.length - 1] + 1];
        for (int[] row : maxReward) {
            Arrays.fill(row, -1);
        }
        return findMaxReward(0, 0, present, maxReward);
    }

    private int findMaxReward(int index, int sum, int[] present, int[][] maxReward) {
        if (index >= present.length || sum >= present[present.length - 1]) {
            return 0;
        }
        if (maxReward[index][sum] == -1) {
            // skip
            maxReward[index][sum] = findMaxReward(index + 1, sum, present, maxReward);
            //pick
            if (present[index] > sum) {
                maxReward[index][sum] = Math.max(maxReward[index][sum], present[index] + findMaxReward(index + 1, present[index] + sum, present, maxReward));
            }
        }
        return maxReward[index][sum];
    }

    private int[] getPresentValues(int[] rewards) {
        int[] present = new int[2001];
        int insertIndex = 0;
        for (int reward : rewards) {
            present[reward] = 1;
        }
        for (int i = 0; i < present.length; i++) {
            if (present[i] == 1) {
                present[insertIndex++] = i;
            }
        }
        return Arrays.copyOf(present, insertIndex);
    }
}
