package com.ss.leetcode.LC2022.january;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    // https://leetcode.com/problems/largest-substring-between-two-equal-characters/
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] lastPositions = new int[26];
        int maxLength = 0;
        Arrays.fill(lastPositions, -1);
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            if (lastPositions[codePoint] >= 0) {
                maxLength = Math.max(maxLength, i - lastPositions[codePoint]);
            }
            lastPositions[codePoint] = i;
        }
        return maxLength - 1;
    }
}
