package com.ss.leetcode.LC2024.october;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    // https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array
    /** Algorithm
        1. The min number of removals is the diff between length of array and longest mountain
        2. The longest mountain is the max length of sum between longest increasing sequence and longest decreasing sequence
        3. Calculate LIS starting from left
        4. Calculate LDS starting from right
        5. For each index, if lis[i] > 1 && lds[i] > 1, check their sum  -1 against the maxSoFar.
     */
    public int minimumMountainRemovals(int[] nums) {
        int minToRemove = nums.length;
        int[] longestIncreasing = getLongestIncreasing(nums);
        int[] longestDecreasing = getLongestDecreasing(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (longestIncreasing[i] > 1 && longestDecreasing[i] > 1) {
                minToRemove = Math.min(minToRemove, nums.length - (longestIncreasing[i] + longestDecreasing[i] - 1));
            }
        }
        return minToRemove;
    }

    private int[] getLongestIncreasing(int[] nums) {
        int[] longestIncreasing = new int[nums.length];
        int candidateIndex;
        for (int i = 0; i < nums.length; i++) {
            longestIncreasing[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                candidateIndex = nums[i] == nums[j] ? longestIncreasing[j] : nums[i] > nums[j] ? 1 + longestIncreasing[j] : 0;
                longestIncreasing[i] = Math.max(longestIncreasing[i], candidateIndex);
            }
        }
        return longestIncreasing;
    }

    private int[] getLongestDecreasing(int[] nums) {
        int[] longestDecreasing = new int[nums.length];
        int candidateIndex;
        for (int i = nums.length - 1; i >= 0; i--) {
            longestDecreasing[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                candidateIndex = nums[i] == nums[j] ? longestDecreasing[j] : nums[i] > nums[j] ? 1 + longestDecreasing[j] : 0;
                longestDecreasing[i] = Math.max(longestDecreasing[i], candidateIndex);
            }
        }
        return longestDecreasing;
    }


    // Will produce TLE as it's 3 pow n complexity
    private static final int ASCENDING = -1, REACHED_TOP = 0, DESCENDING = 1;
    public int minimumMountainRemovals2(int[] nums) {
        Map<Integer, Integer>[] mountains = new Map[nums.length];
        for (int i = 0; i < mountains.length; i++) {
            mountains[i] = new HashMap<>();
        }
        int longestMountain = findMountain(0, Integer.MIN_VALUE, ASCENDING, nums, mountains);
        return nums.length - (longestMountain < 3 ? 0 : longestMountain);
    }

    private int findMountain(int index, int maxSoFar, int ascDesc, int[] nums, Map<Integer, Integer>[] mountains) {
        if (index == nums.length) {
            return ascDesc < DESCENDING ? -nums.length : 0;
        }
        Integer existing = mountains[index].get(maxSoFar);
        if (existing == null) {
            // skip
            existing = findMountain(index + 1, maxSoFar, ascDesc, nums, mountains);
            // pick this one first or continue
            if ((ascDesc == ASCENDING) && (maxSoFar == Integer.MIN_VALUE || maxSoFar < nums[index])) {
                existing = Math.max(existing, 1 + findMountain(index + 1, nums[index], ascDesc, nums, mountains));
            }
            // pick current as top of mountain
            if (ascDesc == ASCENDING && maxSoFar != Integer.MIN_VALUE && maxSoFar < nums[index]) {
                existing = Math.max(existing, 1 + findMountain(index + 1, nums[index], REACHED_TOP, nums, mountains));
            }
            // pick current as DESC if possible
            if ((ascDesc == REACHED_TOP || ascDesc == DESCENDING) && maxSoFar > nums[index]) {
                existing = Math.max(existing, 1 + findMountain(index + 1, nums[index], DESCENDING, nums, mountains));
            }
        }
        return existing;
    }
}
