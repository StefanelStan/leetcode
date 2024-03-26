package com.ss.leetcode.LC2024.march;

public class MinimumSumOfMountainTripletsI {
    // https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i
    /** Algorithm
        1. Traverse array with 2 indices i and j from 0 and n -1.
        2. Use two int[] leftMin[] and rightMin[] to keep track of lowest value of the left, right of each i and j.
        3. Traverse array and precompute the prefix lowest min for each i and lowest right side min for each j
            - EG:[4,3,1,2,5,4]
            - leftMin: [4,3,1,1,1,1]
            - rightMin: [1,1,1,2,4,4]
        4. Traverse with i from 1 to n-1 and if nums[i] > leftMin[i-1] and nums[i] > rightMin[i+1] determine and keep the minSum
        5. Return minSum or -1;
     */
    public int minimumSum(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];
        int prevLeft = Integer.MAX_VALUE, prevRight = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length -1; i < nums.length; i++, j--) {
            leftMin[i] = Math.min(nums[i], prevLeft);
            rightMin[j] = Math.min(nums[j], prevRight);
            prevLeft = leftMin[i];
            prevRight = rightMin[j];
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length -1; i++) {
            if (nums[i] > leftMin[i-1] && nums[i] > rightMin[i+1]) {
                minSum = Math.min(minSum, leftMin[i-1] + nums[i] + rightMin[i+1]);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
