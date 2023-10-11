package com.ss.leetcode.LC2023.october;

public class MaxDotProductOfTwoSubsequences {
    // https://leetcode.com/problems/max-dot-product-of-two-subsequences
    /** Algorithm
        1. Use a maxProducts[nums1.length][nums2.length] to precumpute and select the best products you can
        2. Loop with i from nums1.length -1 to 0 and j from nums2.length -1 to 0.
        3. For each J determine
            a) currentProduct nums1[i] * nums2[j]
            b) the max if you were to select nums1[i+1] => maxProduct[i+1][j] (in case we want to ignore the current product)
            c) the max if you were to select nums2[j+1] => maxProduct[i][j+1](in case we want to ignore the current product)
            d) the max if we were to use the current product and add it to the best product computed so far (maxProduct[i+1][j+1])
        4. Set current maxProduct[i][j] the best of #3: select a OR Max(b,c) OR a + d
        5. Return maxProduct[0][0]
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] maxProducts = new int[nums1.length][nums2.length];
        findMaxProduct(maxProducts, nums1, nums2);
        return maxProducts[0][0];
    }

    private void findMaxProduct(int[][] maxProducts, int[] nums1, int[] nums2) {
        int colProduct, upperRightToCompare, rightSideToAdd, bottomRightToCompare;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                upperRightToCompare = i < nums1.length - 1 ? maxProducts[i+1][j] : Integer.MIN_VALUE;
                bottomRightToCompare = j < nums2.length - 1 ? maxProducts[i][j+1] : Integer.MIN_VALUE;
                rightSideToAdd = i < nums1.length - 1 && j < nums2.length - 1 ? maxProducts[i+1][j+1] : 0;
                colProduct = nums1[i] * nums2[j];
                upperRightToCompare = Math.max(upperRightToCompare, bottomRightToCompare);
                maxProducts[i][j] = Math.max(colProduct, Math.max(upperRightToCompare, colProduct + rightSideToAdd));
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = findLeft(nums, target);
        return left == -1 ? new int[]{-1,-1} : new int[]{left, findRight(nums, target)};
    }

    private int findRight(int[] nums, int target) {
        if (nums[nums.length -1] == target) {
            return nums.length -1;
        }
        int low = 0, high = nums.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] <= target) {
                low = pivot + 1;
            } else {
                high = pivot -1;
            }
        }
        if ((low == 0 && nums[0] != target) || (low == nums.length && nums[low -1] != target)) {
            return -1;
        }
        return nums[low - 1] == target ? low - 1 : -1;
    }

    private int findLeft(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        int low = 0, high = nums.length - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] >= target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        if (high == -1 || (high == nums.length -1 && nums[high] != target) || nums[high + 1] != target) {
            return -1;
        } else {
            return high + 1;
        }
    }
}
