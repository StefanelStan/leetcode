package com.ss.leetcode.LC2022.january;

import java.util.Arrays;

public class MaximumXOROfTwoNumbersInAnArray {
    // https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    // TLE
    public int findMaximumXOR(int[] nums) {
        Arrays.sort(nums);
        int lastOne = getLastOneOrder(nums[nums.length -1]);
        int limit = lastOne > 0 ? (int)Math.pow(2, lastOne) : 0;
        int maxXOR = Integer.MIN_VALUE;
        for (int i = nums.length -1; i >=0 && nums[i] >= limit; i--) {
            for (int j = 0; j <=i; j++) {
                maxXOR = Math.max(maxXOR, nums[i] ^ nums[j]);
            }
        }
        return maxXOR;
    }

    private int getLastOneOrder(int n) {
        int i =0 , lastOne = 0;
        while(n != 0) {
            if ((n & 1) == 1) {
                lastOne = i;
            }
            i++;
            n = n >> 1;
        }
        return lastOne;
    }
}
