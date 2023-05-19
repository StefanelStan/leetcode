package com.ss.leetcode.LC2023.may;

public class FindTheDistinctDifferenceArray {
    // https://leetcode.com/problems/find-the-distinct-difference-array
    /** Algorithm
        1. In order to have faster access to the suffix nums[i+1..n-1] calculate the suffix sum
            of distinct elements starting from n-1 to 0.
            EG: [3,2,3,4,2] will have the distinch backwards suffix sum of [3,3,3,2,1]
            EG: At position[2] we know that we have 3 unique elements starting from [2]
        2. Having #1, traverse nums form   0 to n and
            - if number is not present, increment a leftSum.
            - from leftSum deduct the suffixSum[i+1]
            - set the difference in the answer[] array
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int[] rightDistinct = getRightDistinct(nums);
        int[] difference = new int[nums.length];
        boolean[] onLeft =  new boolean[51];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!onLeft[nums[i]]) {
                prev++;
            }
            difference[i] = prev - (i < nums.length -1 ? rightDistinct[i+1] : 0);
            onLeft[nums[i]] = true;
        }
        return difference;
    }

    private int[] getRightDistinct(int[] nums) {
        boolean[] present = new boolean[51];
        int[] rightDistinct = new int[nums.length];
        int distinct = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            if (!present[nums[i]]) {
                distinct++;
            }
            rightDistinct[i] = distinct;
            present[nums[i]] = true;
        }
        return rightDistinct;
    }
}
