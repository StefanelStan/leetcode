package com.ss.leetcode.LC2022.january;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumDifferenceBetweenIncreasingElements {
    // https://leetcode.com/problems/maximum-difference-between-increasing-elements/
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else {
                maxDiff = Math.max(maxDiff, num - min);
            }
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }

    public int maximumDifference2(int[] nums) {
        int[][] numsAndPos = new int[nums.length][2];
        int maxDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            numsAndPos[i][0] = nums[i];
            numsAndPos[i][1] = i;
        }

        Arrays.sort(numsAndPos, Comparator.comparingInt(a -> a[0]));
        for (int end = nums.length -1; end >= 0; end--) {
            for (int start = 0; start <= end && (end - start >= maxDiff); start++) {
                if (numsAndPos[start][1] < numsAndPos[end][1]) {
                    maxDiff = Math.max(maxDiff, numsAndPos[end][0] - numsAndPos[start][0]);
                }
            }
        }
        return maxDiff > 0 ? maxDiff : -1;
    }
}
