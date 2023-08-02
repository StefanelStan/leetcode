package com.ss.leetcode.LC2023.august;

import java.util.Arrays;

public class FindTheMaximumDivisibilityScore {
    // https://leetcode.com/problems/find-the-maximum-divisibility-score
    /** Algorithm
        1. Sort the numbers in increasing order.
        2. For each divisor, traverse nums backwards with j (n-1..0) WHILE nums[j] >= divisor.
        3. For each traversal keep track of current divisor's currentScore.
            - If currentScore > maxScore, set new maxScore and new minDivisor
            - If currentScore == maxScore, set new minDivisor the min between minDivisor and currentDivisor.
        4. Return minDivisor.
     */
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxDivScore = 0, minDivisor = Integer.MAX_VALUE, currentDivScore;
        Arrays.sort(nums);
        for (int divisor : divisors) {
            currentDivScore = 0;
            for (int i = nums.length - 1; i >= 0 && divisor <= nums[i]; i--) {
                if (nums[i] % divisor == 0) {
                    currentDivScore++;
                }
            }
            if (currentDivScore > maxDivScore) {
                maxDivScore = currentDivScore;
                minDivisor = divisor;
            } else if (currentDivScore == maxDivScore) {
                minDivisor = Math.min(divisor, minDivisor);
            }
        }
        return minDivisor;
    }
}