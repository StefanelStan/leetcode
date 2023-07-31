package com.ss.leetcode.LC2023.july;

import java.util.Arrays;

public class LongestCommonSubsequence {
    // https://leetcode.com/problems/longest-common-subsequence
    /** Algorithm: Levenshtein Distance modification
        1. Use a length[text1.length][text2.length] to map the lengths of combination of i,j (t1, t2)
        2. Recursively, pass i(n,0) and j (m,0) to a function that determines the length of common subsequence
        3. If the two chars match, move both i and j to the left by 1
            eg: i = 3 and j = 2 for abca and abc; as both c match, i will be 2 and j 1
        4. Else, move i left by 1 and separately j by 1. Return and set their min + 1.
        5. length[n][m] will contain the min sum of deletions of from both strings.
            So if we delete 2 chars from t1st1 and 1 from text2, then length[n][m] will contains 3. = 3 deletions in total
            Knowing their lengths (t1.length + t2.length) - length[n][m] we end up with the double of the common subsequence
            EG: abbca and abad. length[n][m] will be 3. (5 + 4) -3 ] 6. 6 is the double of common subsequence. thus 3.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] length = new int[text1.length()][text2.length()];
        for(int[] arr : length) {
            Arrays.fill(arr, -1);
        }
        findCommonSubsequence(text1, text1.length() -1, text2, text2.length() -1, length);
        return (text1.length() + text2.length() - length[text1.length() -1][text2.length() - 1]) / 2;
    }

    private int findCommonSubsequence(String s1, int i, String s2, int j, int[][] length) {
        if (i == -1 || j == -1) {
            return Math.max(i, j) + 1;
        }

        if (length[i][j] == -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                length[i][j] = findCommonSubsequence(s1, i-1, s2, j-1, length);
            } else {
                length[i][j] = 1 + Math.min(findCommonSubsequence(s1, i, s2, j-1, length),
                    findCommonSubsequence(s1, i-1, s2, j, length));
            }
        }
        return length[i][j];
    }
}
