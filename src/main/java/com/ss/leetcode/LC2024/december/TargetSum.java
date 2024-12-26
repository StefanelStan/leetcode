package com.ss.leetcode.LC2024.december;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    // https://leetcode.com/problems/target-sum
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum) {
            return 0;
        }
        Integer[][] posCache = new Integer[nums.length][sum + 1];
        Integer[][] negCache = new Integer[nums.length][sum + 1];
        return findTargetSum(nums, 0, 0, target, posCache, negCache);
    }

    private int findTargetSum(int[] nums, int index, int currentSum, int targetSum, Integer[][] posCache, Integer[][] negCache) {
        if (index == nums.length) {
            return currentSum == targetSum ? 1 : 0;
        }
        Integer[][] targetCache = currentSum < 0 ? negCache : posCache;
        if (targetCache[index][Math.abs(currentSum)] == null) {
            targetCache[index][Math.abs(currentSum)] = findTargetSum(nums, index + 1, currentSum + nums[index], targetSum, posCache, negCache) +
                findTargetSum(nums, index + 1, currentSum - nums[index], targetSum, posCache, negCache);
        }
        return targetCache[index][Math.abs(currentSum)];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        Map<Integer, Integer>[] cache = new Map[nums.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new HashMap<>();
        }
        return findTargetSum(nums, 0, 0, target, cache);
    }

    private int findTargetSum(int[] nums, int index, int currentSum, int targetSum, Map<Integer, Integer>[] cache) {
        if (index == nums.length) {
            return currentSum == targetSum ? 1 : 0;
        }
        Integer val = cache[index].get(currentSum);
        if (val == null) {
            val = findTargetSum(nums, index + 1, currentSum + nums[index], targetSum, cache) +
                findTargetSum(nums, index + 1, currentSum - nums[index], targetSum, cache);
            cache[index].put(currentSum, val);
        }
        return val;
    }

    public int findTargetSumWays3(int[] nums, int target) {
        return findTargetSum(nums, 0, 0, target);
    }

    private int findTargetSum(int[] nums, int index, int currentSum, int targetSum) {
        if (index == nums.length) {
            return currentSum == targetSum ? 1 : 0;
        }
        return findTargetSum(nums, index + 1, currentSum + nums[index], targetSum) +
            findTargetSum(nums, index + 1, currentSum - nums[index], targetSum);
    }
}
