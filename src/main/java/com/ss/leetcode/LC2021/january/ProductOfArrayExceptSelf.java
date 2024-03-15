package com.ss.leetcode.LC2021.january;

public class ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    /** Algorithm
        1. Traverse and multiply the numbers IF they are not 0. Also keep track of number of 0s
        2. If you have more than 1 zero, return new int[nums.length] because any prefix will be 0
        3. Traverse answer[] and if current number if zero, set the value to be product, else product/nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeroes = 0;
        for (int i = 0; i < nums.length && zeroes < 2; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroes++;
            }
        }
        return getProducts(nums, product, zeroes);
    }

    private int[] getProducts(int[] nums, int product, int zeroes) {
        int[] products = new int[nums.length];
        if (zeroes < 2) {
            for (int i = 0; i < products.length; i++) {
                products[i] = nums[i] == 0 ? product : zeroes == 1 ? 0 : product / nums[i];
            }
        }
        return products;
    }


    public int[] productExceptSelf2(int[] nums) {
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
