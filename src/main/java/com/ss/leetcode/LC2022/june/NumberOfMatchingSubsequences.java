package com.ss.leetcode.LC2022.june;

import java.util.Arrays;

public class NumberOfMatchingSubsequences {
    // https://leetcode.com/problems/number-of-matching-subsequences/
    /** Algorithm
         1. The essence of the algorithm tries to compare/ search if a subsequence "ade" is found inside a string "abcde".
         2. As any algorithm, it tries to search the letters of subseq starting with first, then second.
            Thus, using 2 indices i and j traverse string and substring, stopping when i or j reach max size.
         3. However, this can be a bit inneficient due to strings like "aaaaaaaaaaaab" - "ab" when after matching first letter a,
            it will continue going to 2nd, 3rd... and barely when reading index 13 it will match letter b.
         4. Thus, let's cache the starting positions of each letter of string.
             So, upon searching, the search index i will be set to the max between current i and startintPosition of next letter of subsequence. (eg: b).
             So, after matching a, i will jump to 13, as 13 is > 1 and it is the starting  position of letter b.
             Also, if this starting position is not founf (eg: -1), then return immediately as this letter does not exist
     */
    public int numMatchingSubseq(String s, String[] words) {
        int matching = 0;
        char[] sChars = s.toCharArray();
        int[] startPos =  new int[26];
        fillStartPositions(sChars, startPos);
        for (String word: words) {
            matching += isSubsequence(sChars, word.toCharArray(), startPos) ? 1 : 0;
        }
        return matching;
    }

    // fills the starting positions of each letter. This will provide a basic starting index of search.
    private void fillStartPositions(char[] sChars, int[] startPos) {
        Arrays.fill(startPos, -1);
        int codePoint;
        for (int i = 0; i < sChars.length; i++) {
            codePoint = sChars[i] - 'a';
            if (startPos[codePoint] == -1) {
                startPos[codePoint] = i;
            }
        }
    }

    private boolean isSubsequence(char[] sChars, char[] strChars, int[] startPos) {
        if (sChars.length < strChars.length) {
            return false;
        } else if (sChars.length == strChars.length) {
            return areArraysEqual(sChars, strChars);
        } else {
            int i = 0, j = 0;
            int jCodePoint;
            // while i and j did not reach the end of their char array AND the remaing section of string is > remaining section of substring
            // eg: aaaaabcd  - abcdefghij
            // when b is found, the remaining 2 char cannot definitely find/fill 'fghij' (2 < 5) so return.
            while (i < sChars.length && j < strChars.length && sChars.length - i >= strChars.length - j) {
                jCodePoint = strChars[j] - 'a';
                // if current letter of j is not found, return
                if (startPos[jCodePoint] == -1) {
                    return false;
                } else {
                    // else skip i to the max between starting position of letter or current i
                    // eg: "aaaaaaaab" "ab". One a is found, then i will skip to where b starts, position 8
                    i = Math.max(i, startPos[jCodePoint]);
                }
                // if the two letters match, advance both indices
                if (sChars[i++] == strChars[j]) {
                    j++;
                }
            }
            return j == strChars.length;
        }
    }

    private boolean areArraysEqual(char[] c1, char[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
