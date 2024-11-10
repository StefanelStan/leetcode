package com.ss.leetcode.LC2024.november;

public class ShortestSubarrayWithORAtLeastKII {
    // https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii
    /** Algorithm
        1. Sliding window: use left and right pointers and an int[32] to mark the count of each bits.
        2. Add right and reduce window (leftt++) while the number represented by int[32] is >= k. Alse set the min length;
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int minLength = Integer.MAX_VALUE;
        int[] bitCount = new int[32];
        for (int left = 0, right = 0; right < nums.length; right++) {
            addBitCount(bitCount, nums[right]);
            while (valueOf(bitCount) >= k) {
                minLength = Math.min(minLength, 1 + right - left);
                removeBitCount(bitCount, nums[left++]);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private void addBitCount(int[] bitCount, int num) {
        for (int i = 31; i >= 0 && num > 0; i--) {
            bitCount[i] += (int)(num & 1);
            num = num >> 1;
        }
    }

    private void removeBitCount(int[] bitCount, int num) {
        for (int i = 31; i >= 0 && num > 0; i--) {
            bitCount[i] -= 1 == (int)(num & 1) ? 1 : 0;
            num = num >> 1;
        }
    }

    private int valueOf(int[] bitCount) {
        int prod = 0;
        for (int count : bitCount) {
            prod = prod * 2 + (count == 0 ? 0 : 1);
        }
        return prod;
    }
}
