package com.ss.leetcode.LC2023.july;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings {
    // https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
    /** Algorithm: Levenshtein distance adaptation: only for delete and count ascii value not deletion count
        1. Get the prefix sum of chars of s1, s2.
        2. Use an int[s1.length][s2.length] deletions to keep track of minimum ascii deletion
        3. deletions[n][m] will contain the answer of min deletions
        4. Recursively with i from n and j from m check the chars
            - if chars match, set deletions as rec(i-1, j-1): move both pointers to the left
            - if any pointer reaches -1, it means we finished one word but it might have other chars
                from the other word. Return the prefix of the other index, if index >= 0
            - if chars to not match, return the min of (s1[i] + rec(i-1), s2[j] + rec(j-1):
                move i left and also move j left in two separate calls.
            Their min ascii result will be persisted in deletions[i][j].
        5. Return deletions[n][m]
     */
    public int minimumDeleteSum(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int[] s1Sum = getPrefixSum(s1Chars);
        int[] s2Sum = getPrefixSum(s2Chars);
        int[][] deletions = new int[s1.length()][s2.length()];
        for (int[] row : deletions) {
            Arrays.fill(row, -1);
        }
        findCommonSubsequence(s1Chars, s1.length() -1, s2Chars, s2.length() -1, s1Sum, s2Sum, deletions);
        return deletions[s1.length() - 1][s2.length() - 1];
    }

    private int findCommonSubsequence(char[] s1, int i, char[] s2, int j, int[] s1Sum, int[] s2Sum, int[][] deletions) {
        if (i == -1) {
            return j == -1 ? 0 : s2Sum[j];
        } else if (j == -1) {
            return s1Sum[i];
        }
        if (deletions[i][j] == -1) {
            if (s1[i] == s2[j]) {
                deletions[i][j] = findCommonSubsequence(s1, i-1, s2, j-1, s1Sum, s2Sum, deletions);
            } else {
                int deleteS1 = s1[i] + findCommonSubsequence(s1, i-1, s2, j, s1Sum, s2Sum, deletions);
                int deleteS2 = s2[j] + findCommonSubsequence(s1, i, s2, j-1, s1Sum, s2Sum, deletions);
                deletions[i][j] = Math.min(deleteS1, deleteS2);
            }
        }
        return deletions[i][j];
    }

    private int[] getPrefixSum(char[] chrs) {
        int[] sum = new int[chrs.length];
        sum[0] = chrs[0];
        for (int i = 1; i < chrs.length; i++) {
            sum[i] += sum[i-1] + chrs[i];
        }
        return sum;
    }
}
