package com.ss.leetcode.LC2023.may;

public class MinimumSizeSubarraySum {
    // https://leetcode.com/problems/minimum-size-subarray-sum
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (left < nums.length || right < nums.length) {
            if (sum < target) {
                if (right < nums.length) {
                    sum += nums[right];
                    right++;
                } else {
                    break;
                }
            } else {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
                right = Math.max(right, left);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // via binary search
    public int minSubArrayLen2(int target, int[] nums) {
        int[] rollingSum = new int[nums.length];
        int minSubArray = Integer.MAX_VALUE, prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            rollingSum[i] = prevSum + nums[i];
            if (rollingSum[i] >= target) {
                minSubArray = Math.min(minSubArray, i - binarySearch(rollingSum, rollingSum[i] - target, i));
            }
            prevSum = rollingSum[i];
        }
        return minSubArray == Integer.MAX_VALUE ? 0 : minSubArray;
    }

    private int binarySearch(int[] nums, int target, int right) {
        int left = 0, pivot;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left - 1;
    }


}
