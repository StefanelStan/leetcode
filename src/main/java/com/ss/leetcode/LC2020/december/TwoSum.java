package com.ss.leetcode.LC2020.december;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer possible = numsSoFar.get(target - nums[i]);
            if (possible != null) {
                return new int[]{possible, i};
            } else {
                numsSoFar.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsToPosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsToPosition.put(nums[i], i);
        }

        int tempDiff;
        Integer position = null;
        for (int i = 0; i < nums.length; i++) {
            tempDiff = target - nums[i];
            position = numsToPosition.get(tempDiff);
            if (position!= null && position != i) {
                return new int[]{i, position};
            }
        }
        return new int[]{0,0};
    }

    public int[] twoSumLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length -1 ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }
}
