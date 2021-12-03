package com.ss.leetcode.LC2021.december;

public class MaximumProductSubarray {
    // https://leetcode.com/problems/maximum-product-subarray/
    public int maxProduct(int[] nums) {
        long maxProduct = Long.MIN_VALUE;
        boolean aboveInterval = false;
        int fNegative = -1, lNegative = -1;
        int seqStart = -1;
        long seqProduct = 1;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (!aboveInterval) {
                    aboveInterval = true;
                    seqStart = i;
                }
                if (nums[i] < 0) {
                    if (fNegative == -1) {
                        fNegative = i;
                    } else {
                        lNegative = i;
                    }
                }
                seqProduct *= nums[i];
            }
            if (nums[i] == 0 || i == nums.length - 1) {
                if (nums[i] == 0) {
                    hasZero = true;
                }
                if (aboveInterval) {
                    if (seqProduct > 0) {
                        maxProduct = Math.max(maxProduct, seqProduct);
                    } else {
                        if (i == nums.length -1 && nums[i] != 0) i = nums.length;
                        maxProduct = Math.max(getMaxProductOfInterval(nums, seqStart, i -1, fNegative, lNegative, seqProduct), maxProduct);
                    }
                    fNegative = -1;
                    lNegative = -1;
                    seqStart = -1;
                    seqProduct = 1;
                    aboveInterval = false;
                }
            }
        }

        return (int) (hasZero ? Math.max(0, maxProduct) : maxProduct);
    }

    private long getMaxProductOfInterval(int[] nums, int start, int end, int fNegative, int lNegative, long product) {
        if (start == end) {
            return product;
        }
        if (lNegative == -1) {
            lNegative = fNegative;
        }
        long leftSideProd =1, rightSideProd = 1;
        for (int i = start; i <= fNegative; i++) {
            leftSideProd *= nums[i];
        }
        for (int i = lNegative; i <= end; i++) {
            rightSideProd *= nums[i];
        }
        return Math.max(product / leftSideProd, product / rightSideProd);
    }
}
