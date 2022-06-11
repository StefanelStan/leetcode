package com.ss.leetcode.LC2022.june;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> sums = new HashMap<>();
        int rollingSum = 0;
        for (int i = 0; i < nums.length && rollingSum <= x; i++) {
            rollingSum += nums[i];
            sums.put(rollingSum, i);
        }
        int minOperations;
        if (rollingSum < x) {
            minOperations = -1;
        } else if (rollingSum == x) {
            minOperations = nums.length;
        } else {
            minOperations = getMinOperations(sums, nums, rollingSum, x);
        }
        return minOperations;
    }

    private int getMinOperations(Map<Integer, Integer> sumsToPositions, int[] nums, int totalSum, int targetSum) {
        int size = nums.length;
        int minOperations = sumsToPositions.getOrDefault(targetSum, size -1);
        minOperations++;
        int rightSum = 0;
        for (int i = size -1; i > 0 && rightSum < targetSum ; i--) {
            rightSum += nums[i];
            if (rightSum == targetSum) {
                minOperations = Math.min(minOperations, size - i);
            } else if (rightSum < targetSum){
                Integer left = sumsToPositions.get(targetSum - rightSum);
                if (left != null) {
                    minOperations = Math.min(minOperations, left + 1 + size - i);
                }
            }
        }
        return minOperations == size ? -1 : minOperations;
    }
}
