package com.ss.leetcode.LC2023.june;

import java.util.Arrays;

public class LongestIdealSubsequence {
    // https://leetcode.com/problems/longest-ideal-subsequence
    /** Algorithm EG: "acfgbd", k = 2
        1. Start from the back, (letter d) and see what is the max chain d can make.
            As it's the last letter, it can make a chain of 1 (itself)
        2. Use an int[26] (a-z) to mark the chain length that current letter can make with the letters to the LEFT on its position.
            b has letter d to its left. As b + 2 <= d, d is a valid chain so int[b] = int[d] + 1 (2)
        3. When deciding what letters are BEST to make a chain FOR the current letter,
            do not travel to the LEFT of the string, as string can have 10^5 elements,
            Instead travel to the left/right of current letter inside the int[].
            EG: travel k elements to the left and right of b : 2 elements at the left of b inside [] are -1 and a.
            Two elements at the right of b inside int[] are c and d. The max between these 5 is 1 so int[b] = int[d] + 1.
        4. g -> travel 2 letters to the left of g (e,f) and 2 letters at the right of g (h,i). Determine their max and set int[g] = max + 1.
        5. When doing this for all letters inside the string, traverse the int[] and return the max value recorded.
     */
    public int longestIdealString(String s, int k) {
        int[] lengths = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            computeLength(s.charAt(i) - 'a', lengths, k);
        }
        return Arrays.stream(lengths).max().getAsInt();
    }

    private void computeLength(int from, int[] lengths, int k) {
        int minLength = 0;
        int steps = 0;
        while (steps <= k && from - steps >= 0) {
            minLength = Math.max(minLength, lengths[from - steps]);
            steps++;
        }
        steps = 0;
        while (steps <= k && from + steps < 26) {
            minLength = Math.max(minLength, lengths[from + steps]);
            steps++;
        }
        lengths[from] = 1 + minLength;
    }

    // Alternative DP solution
    private static final char NOT_SELECTED = 'z' + 1;
    public int longestIdealString2(String s, int k) {
        if (k == 25) {
            return s.length();
        }
        Integer[][] lengths = new Integer[s.length()][27];
        return findLength(s.toCharArray(), 0, NOT_SELECTED, k, lengths);
    }

    private int findLength(char[] chars, int index, char lastSelected, int k, Integer[][] lengths) {
        if (index == chars.length) {
            return 0;
        }
        int codePoint = lastSelected - 'a';
        if (lengths[index][codePoint] == null) {
            // skip
            lengths[index][codePoint] = findLength(chars, index + 1, lastSelected, k, lengths);
            if (lastSelected == NOT_SELECTED || Math.abs(chars[index] - lastSelected) <= k) {
                lengths[index][codePoint] = Math.max(lengths[index][codePoint],
                    1 + findLength(chars, index + 1, chars[index], k, lengths));
            }
        }
        return lengths[index][codePoint];
    }
}
