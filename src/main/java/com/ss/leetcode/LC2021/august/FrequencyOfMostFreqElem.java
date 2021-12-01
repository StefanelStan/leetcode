package com.ss.leetcode.LC2021.august;

import java.util.Arrays;

public class FrequencyOfMostFreqElem {
    // https://leetcode.com/problems/frequency-of-the-most-frequent-element/
    public int maxFrequency(int[] nums, int k) {
        /**
         * Worth implementing a mechanism to keep track of sum of differences from left to right and right to left.
         * Thus could loop and find the maxInterval
         */
        Arrays.sort(nums);
        int maxFrequency = 1, currentFrequency = 1;
        int totalIncrements = k;
        for (int i = nums.length -1; i > 0; i--) {
            currentFrequency = 1;
            totalIncrements = k;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] - nums[j] <= totalIncrements) {
                    currentFrequency++;
                    totalIncrements -= nums[i] - nums[j];
                    if (currentFrequency > maxFrequency) {
                        maxFrequency = currentFrequency;
                    }
                } else {
                    break;
                }
            }
        }
        return maxFrequency;
    }
}
