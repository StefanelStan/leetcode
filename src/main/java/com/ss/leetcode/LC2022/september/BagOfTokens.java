package com.ss.leetcode.LC2022.september;

import java.util.Arrays;

public class BagOfTokens {
    // https://leetcode.com/problems/bag-of-tokens/
    /** Algorithm
         1. Looking at the problem, you realize that you might want to face down the largest tokens
            to gain the max power (if you don't have enough power) AND to face up the smallest tokens (when you have sufficient power)
         2. So sort the tokens and use 2 pointers: left and right.
         3. If you have enough power, flip the left token (small one) and gain 1 point
         4. If you don't have enough power AND your score is at least 1, flip the right token
            and gain power and lose 1 score.
         5. If unable to do 3 or 4, it means you are stuck so your game is over (break).
         6. Return the max score from any of these steps
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore = 0;
        int currentScore = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                currentScore++;
                maxScore = Math.max(maxScore, currentScore);
            } else if (currentScore >= 1) {
                power += tokens[right--];
                currentScore--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
