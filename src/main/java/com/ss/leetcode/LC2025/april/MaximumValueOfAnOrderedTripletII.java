package com.ss.leetcode.LC2025.april;

public class MaximumValueOfAnOrderedTripletII {
    // https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii
    /** Algorithm
        1. The best triplet for a current index i [1.. n-2] is (max[i-1] - nums[i]) * max[i+1].
        2. Traverse nums and set max[] - prefix max value of each index.
        3. Traverse nums backwards (n-2.. 1) and for each index j, determine the max between (max[i-1] - nums[j]) * max[j+1].
        4. Return 0 if the answer is negative, else the answer.
     */
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = Long.MIN_VALUE;
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            max[i] = Math.max(max[i-1], nums[i]);
        }
        int maxK = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            maxTriplet = Math.max(maxTriplet, (long)(max[i-1] - nums[i]) * maxK);
            maxK = Math.max(maxK, nums[i]);
        }
        return Math.max(maxTriplet, 0);
    }
}
