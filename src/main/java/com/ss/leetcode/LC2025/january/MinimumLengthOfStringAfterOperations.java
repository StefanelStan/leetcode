package com.ss.leetcode.LC2025.january;

public class MinimumLengthOfStringAfterOperations {
    // https://leetcode.com/problems/minimum-length-of-string-after-operations
    /** Algorithm
        1. Traverse s and count each letter in an int[26] charCount;
        2. For each count that is > 0
            - with each deletion operation, you can delete 2 characters.
            - however, for even numbers, once you reach 2, you cannot make deletions:
            - EG: count = 6 -> 4 -> 2 (no more deletions) (even count stops at 2)
            - count = 5: 5 -> 3 -> 1 (no more deletions) (odd count stops at 1)
        3. Traverse count and if count > 0, add 2 or 1, based on parity.
     */
    public int minimumLength(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int minLength = 0;
        for (int count : charCount) {
            if (count > 0) {
                count = (count % 2 == 0 ? 2 : 1);
            }
            minLength += count;
        }
        return minLength;
    }
}
