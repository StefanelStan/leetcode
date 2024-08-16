package com.ss.leetcode.LC2024.august;

public class FindKthSmallestPairDistance {
    // https://leetcode.com/problems/find-k-th-smallest-pair-distance
    public int smallestDistancePair(int[] nums, int k) {
        int max = 1_000_001, min = 0;
        for (int num :nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] bucketDistances = new int[1 + max - min];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                bucketDistances[Math.abs(nums[i] - nums[j])]++;
            }
        }
        int i = 0;
        for (; i < bucketDistances.length && k > 0; i++) {
            k -= bucketDistances[i];
        }
        return i - 1;
    }
}
