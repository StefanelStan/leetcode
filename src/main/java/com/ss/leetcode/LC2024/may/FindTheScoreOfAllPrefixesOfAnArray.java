package com.ss.leetcode.LC2024.may;

public class FindTheScoreOfAllPrefixesOfAnArray {
    // https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array
    /** Algorithm
        1. Use a long[] prefixScore to store the score of prefix
        2. Traverse nums and determine the max so far
        3. Set prefixScore[i] = prefixScore[i-1] + maxNum + num[i]
        4. Return prefixScore;
     */
    public long[] findPrefixScore(int[] nums) {
        int maxNum = 0;
        long[] prefixScore = new long[nums.length];
        long prevScore = 0;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            prefixScore[i] = prevScore + maxNum + nums[i];
            prevScore = prefixScore[i];
        }
        return prefixScore;
    }
}
