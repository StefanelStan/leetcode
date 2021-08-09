package com.ss.leetcode.august;

public class MinimumDistanceTargetElement {
    // https://leetcode.com/problems/minimum-distance-to-the-target-element/
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = 0;
        minDistance = Math.min(searchOnLeft(nums, target, start), searchOnRight(nums, target, start));
        return minDistance;
    }

    private int searchOnLeft(int[] nums, int target, int start) {
        for(int i = start -1; i >=0; i--) {
            if (nums[i] == target) {
                return Math.abs(i - start);
            }
        }
        return Integer.MAX_VALUE;
    }

    private int searchOnRight(int[] nums, int target, int start) {
        for(int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                return Math.abs(i - start);
            }
        }
        return Integer.MAX_VALUE;
    }
}
