package com.ss.leetcode.LC2024.may;

public class SumOfBeautyInTheArray {
    // https://leetcode.com/problems/sum-of-beauty-in-the-array
    /** Algorithm
        1. In order to know if nums[i] < nums[k] (for all k = i + 1 .n-1) you need to know the minimum on the right side of i
        2. Use an int[] minOnRight to calculate the min on right side for each i (n-1..0)
        3. Traverse from 1 to n-2 and keep track of maximum encounterd so far.
        4. If maxSoFar < current && current < minOnright[i+1] then add 2. Else check the other condition and add 1 or 0.
     */
    public int sumOfBeauties(int[] nums) {
        int beautySum = 0;
        int[] minOnRight = getMinOnRight(nums);
        int maxOnLeft = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (maxOnLeft < nums[i] && nums[i] < minOnRight[i+1]) {
                beautySum += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                beautySum += 1;
            }
            maxOnLeft = Math.max(maxOnLeft, nums[i]);
        }
        return beautySum;
    }

    private int[] getMinOnRight(int[] nums) {
        int[] minOnRight = new int[nums.length];
        minOnRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            minOnRight[i] = Math.min(minOnRight[i + 1], nums[i]);
        }
        return minOnRight;
    }
}
