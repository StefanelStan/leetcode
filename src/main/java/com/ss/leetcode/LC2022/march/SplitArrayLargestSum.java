package com.ss.leetcode.LC2022.march;

public class SplitArrayLargestSum {
    // https://leetcode.com/problems/split-array-largest-sum/
    public int splitArray(int[] nums, int m) {
        int[] sumAndMax = getSumAndMax(nums);
        int left = sumAndMax[1], right = sumAndMax[0];
        int reqNumberOfSegments = 0, pivot = 0;
        int maxSplitSum = 0;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            reqNumberOfSegments = getReqNumberOfSegments(nums, pivot);
            if (reqNumberOfSegments <= m) {
                right = pivot -1;
                maxSplitSum = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return maxSplitSum;
    }

    private int[] getSumAndMax(int[] nums) {
        int[] sumAndMax = {0, Integer.MIN_VALUE};
        for (int num : nums) {
            sumAndMax[0] += num;
            sumAndMax[1] = Math.max(sumAndMax[1], num);
        }
        return sumAndMax;
    }

    private int getReqNumberOfSegments(int[] nums, int targetSum) {
        int nrOfSegments = 0;
        int sum = 0;
        for(int num: nums) {
            if (sum + num <= targetSum) {
                sum += num;
            } else {
                nrOfSegments++;
                sum = num;
            }
        }
        return nrOfSegments + 1;
    }
}
