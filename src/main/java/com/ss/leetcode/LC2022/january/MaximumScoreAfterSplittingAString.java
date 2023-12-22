package com.ss.leetcode.LC2022.january;

public class MaximumScoreAfterSplittingAString {
    // https://leetcode.com/problems/maximum-score-after-splitting-a-string/
    /** Algorithm
        1. Traverse the string and count total number of 1s.
        2. Traverse the string again from 0 to n-2 (n-2 because you won't select the last index') and for each index:
            - Keep  track of the currentZeroes and currentOnes.
            - The number of 1s on the right side is totalOnes - currentOnes.
            - Determine the max of currentZeroes + (totalOnes - currentOnes).
     */
    public int maxScore(String s) {
        int totalOnes = 0, currentOnes = 0, currentZeroes = 0;
        int maxScore = 0;
        for (int i = 0; i < s.length(); i++) {
            totalOnes += (s.charAt(i) - '0');
        }
        if (totalOnes == s.length() || totalOnes == 0) {
            return s.length() -1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                currentZeroes++;
            } else {
                currentOnes++;
            }
            maxScore = Math.max(maxScore, currentZeroes + (totalOnes - currentOnes));
        }
        return maxScore;
    }
}
