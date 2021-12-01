package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class ThreeSumClosest {
    // https://leetcode.com/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int targetDiff, low, high, innerSum;
        int[] closestTarget = { 100_000 };
        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;
            targetDiff = target - nums[i];
            while (low < high) {
                innerSum = getInnerSum(closestTarget, nums[i], nums[low], nums[high], target);
                if (innerSum > targetDiff) {
                    high--;
                } else if (innerSum < targetDiff) {
                    low++;
                } else {
                    return innerSum + nums[i];
                }
            }
        }
        return closestTarget[0];
    }

    private int getInnerSum(int[] closestTarget, int iValue, int lowValue, int highValue, int target) {
        if (Math.abs(target - closestTarget[0]) > Math.abs(target - (iValue + lowValue + highValue))) {
            closestTarget[0] = iValue + lowValue + highValue;
        }
        return lowValue + highValue;
    }
}
