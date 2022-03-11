package com.ss.leetcode.LC2022.march;

public class CountSpecialQuadruplets {
    // https://leetcode.com/problems/count-special-quadruplets/
    public int countQuadruplets(int[] nums) {
        int sum1, sum2, count = 0;
        for (int i = 0; i < nums.length -3; i++) {
            for (int j = i +1; j < nums.length -2; j++) {
                sum1 = nums[i] + nums[j];
                for (int k = j +1; k < nums.length -1; k++) {
                    sum2 = sum1 + nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        if (nums[l] == sum2) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
