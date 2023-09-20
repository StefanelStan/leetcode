package com.ss.leetcode.LC2022.june;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    /** Algorithm
        1. Try to detect all 3 possible cases: only on left, combined (few left/right) and only right.
        2. Expand window from 0 to the right side. Stop when prefixSum >= x
        3. Fail fast cases:
            - if windowSize == nums.length return nums.length
            - if prefimSum < x return -1;
        4. Try to wiggle the window:
            - if prefixSum > x, decrease left and deduct from sum
            - if prefix < x, move right pointer to left and add it to sum
            - stop when left reaches -1;
        5. Attempts to move right pointer to left as long as sum < x.
     */
    public int minOperations(int[] nums, int x) {
        int left = -1, right = nums.length;
        int currentSum = 0;
        int minOperations = Integer.MAX_VALUE;
        while (left < nums.length -1 && currentSum < x) {
            left++;
            currentSum += nums[left];
        }
        if (currentSum == x) {
            minOperations = left + 1;
            if (left == nums.length -1) {
                return minOperations;
            }
        }
        if (currentSum < x) {
            return -1;
        }
        while (left >= 0) {
            if (currentSum == x) {
                minOperations = Math.min(minOperations, left + 1 + nums.length - right);
                currentSum -= nums[left];
                left--;
            } else if (currentSum < x) {
                right--;
                currentSum += nums[right];
            } else {
                currentSum -= nums[left--];
            }
        }
        while (right > 0 && currentSum < x) {
            right--;
            currentSum += nums[right];
        }
        if (currentSum == x) {
            minOperations = Math.min(minOperations, nums.length - right);
        }
        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }


    public int minOperations2(int[] nums, int x) {
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
