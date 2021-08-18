package com.ss.leetcode.august;

public class SignOfTheProductOfAnArray {
    // https://leetcode.com/problems/sign-of-the-product-of-an-array/
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int num : nums) {
            if (num == 0) {
                prod = 0;
                break;
            } else if (num < 0) {
                prod *= -1;
            }
        }
        return prod;
    }
}
