package com.ss.leetcode.LC2023.january;

public class SubarraySumsDivisibleByK {
    // https://leetcode.com/problems/subarray-sums-divisible-by-k
    // TLE
    public int subarraysDivByK(int[] nums, int k) {
        int numOfSubarrays = 0, rollingSum = 0, tempSum;
        for (int i = 0; i < nums.length; i++) {
            rollingSum += nums[i];
            if (rollingSum % k == 0) {
                numOfSubarrays++;
            }
            tempSum = rollingSum;
            for (int j = 0; j < i; j++) {
                tempSum -= nums[j];
                if (tempSum % k == 0) {
                    numOfSubarrays++;
                }
            }
        }
        return numOfSubarrays;
    }
}
