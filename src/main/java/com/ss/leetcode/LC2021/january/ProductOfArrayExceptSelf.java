package com.ss.leetcode.LC2021.january;

public class ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        boolean hasOneZero = false;
        for (int num : nums) {
            if (num == 0) {
                if (!hasOneZero) {
                    hasOneZero = true;
                } else {
                    product *= num;
                }
            } else {
                product *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(hasOneZero) {
                if(nums[i] != 0) {
                    result[i] = 0;
                } else {
                    result[i] = product / (nums[i] == 0 ? 1 : nums[i]);
                }
            } else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}
