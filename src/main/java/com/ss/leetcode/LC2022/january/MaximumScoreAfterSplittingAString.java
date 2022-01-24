package com.ss.leetcode.LC2022.january;

public class MaximumScoreAfterSplittingAString {
    // https://leetcode.com/problems/maximum-score-after-splitting-a-string/
    public int maxScore(String s) {
        int numberOfZeroes = 0;
        int numberOfOnes = 0;
        for(int i = 0; i < s.length(); i++) {
            numberOfOnes += s.charAt(i) - '0';
        }
        numberOfZeroes = s.length() - numberOfOnes;
        if (numberOfOnes == 0 || numberOfZeroes == 0) {
            return s.length() - 1;
        }
        int maxScore = 0;
        int countedZeroes = 0, countedOnes = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                countedZeroes++;
            } else {
                countedOnes++;
            }
            maxScore = Math.max(maxScore, countedZeroes + numberOfOnes - countedOnes);
        }
        return maxScore;
    }
}
