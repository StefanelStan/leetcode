package com.ss.leetcode.LC2024.august;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceII {
    // https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii
    /** Algorithm
        1. Use a Map<Integer, Integer>[26] to map the lengths of each subseq of chars
        2. Traverse s and when a char swap is detected, insert the lengths of prev subsequence
        3. Insertion: a string of length n produces:
            - 1 subseq of length n
            - 2 subseq and length n-1
            - 3 subseq of length n-2
            - and so on
        4. Result of insert a subseq of length n
            - if the new count is > 2, then you already have 3 or more subseq of length n, so n can be a candidate
            - if the new count is < 2, then this n subseq can give 3 subsequences of n-2 length; n -2 can be a candidate
        5. Return the max candidate
     */
    public int maximumLength(String s) {
        int maxLength = -1, currentLength = 1;
        char prevChar = s.charAt(0), currentChar = 0;
        Map<Integer, Integer>[] substringLengths = new Map[26];
        for (int i = 1; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (prevChar != currentChar) {
                maxLength = Math.max(maxLength, appendSubseq(substringLengths, prevChar - 'a', currentLength));
                currentLength = 0;
            }
            currentLength++;
            prevChar = currentChar;
        }
        maxLength = Math.max(maxLength, appendSubseq(substringLengths, currentChar - 'a', currentLength));
        return maxLength;
    }

    private int appendSubseq(Map<Integer, Integer>[] substringLengths, int codePoint, int length) {
        int max = -1, subseqCount;
        for (int count = 1; length > 0; count++, length--) {
            if (substringLengths[codePoint] == null) {
                substringLengths[codePoint] = new HashMap<>();
            }
            subseqCount = substringLengths[codePoint].merge(length, count, Integer::sum);
            max = Math.max(max, subseqCount > 2 ? length : length > 2 ? length - 2 : -1);
        }
        return max;
    }
}
