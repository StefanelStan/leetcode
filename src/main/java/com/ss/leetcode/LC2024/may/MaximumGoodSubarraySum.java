package com.ss.leetcode.LC2024.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumGoodSubarraySum {
    // https://leetcode.com/problems/maximum-good-subarray-sum/
    // TLE
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> positions = new HashMap<>(nums.length);
        long[] prefixSum = new long[nums.length];
        long maxSum = Long.MIN_VALUE, prevPrefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = prevPrefix + nums[i];
            prevPrefix = prefixSum[i];
            maxSum = Math.max(maxSum,
                Math.max(maxSubarray(nums[i] - k, i, positions, prefixSum), maxSubarray(nums[i] + k, i, positions, prefixSum)));
            positions.computeIfAbsent(nums[i], p -> new ArrayList<>()).add(i);
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    private long maxSubarray(int target, int currentIndex, Map<Integer, List<Integer>> positions, long[] prefixSum) {
        List<Integer> targetPos = positions.get(target);
        long maxSum = Long.MIN_VALUE;
        if (targetPos == null) {
            return maxSum;
        }
        for (int pos : targetPos) {
            maxSum = Math.max(maxSum, prefixSum[currentIndex] - (pos == 0 ? 0 : prefixSum[pos - 1]));
        }
        return maxSum;
    }
}
