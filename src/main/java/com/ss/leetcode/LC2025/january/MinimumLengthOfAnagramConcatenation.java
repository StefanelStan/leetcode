package com.ss.leetcode.LC2025.january;

public class MinimumLengthOfAnagramConcatenation {
    // https://leetcode.com/problems/minimum-length-of-anagram-concatenation
    /** Algorithm
        1. The anagram must be a word (substring) that has a length divisible by given words' length
        2. Loop from i = 0 to n/2;
            - for each index, mark the letterCount of each letter in a letterCount[26]
            - if n is divisible by i, check if the letter count of segment [i+1, 2n], [2i + 1, 3i].. has the same letter count as current Lettercount
            - If yes, return index i
        3. Return n by default, as no anagram was found.
     */
    public int minAnagramLength(String s) {
        char[] chars = s.toCharArray();
        int[] letterCount = new int[26];
        for (int i = 0; i <= chars.length / 2; i++) {
            letterCount[chars[i] - 'a']++;
            if (chars.length % (i + 1) == 0 && isRepeatingAnagram(chars, i + 1, letterCount)) {
                return i + 1;
            }
        }
        return chars.length;
    }

    private boolean isRepeatingAnagram(char[] chars, int size, int[] matching) {
        for (int i = size; i <= chars.length - size;  i += size) {
            int[] fingerPrint = new int[26];
            for (int j = i; j < i + size; j++) {
                if (matching[chars[j] - 'a'] < ++fingerPrint[chars[j] - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }
}
