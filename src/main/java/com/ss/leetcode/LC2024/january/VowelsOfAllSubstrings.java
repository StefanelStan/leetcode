package com.ss.leetcode.LC2024.january;

public class VowelsOfAllSubstrings {
    // https://leetcode.com/problems/vowels-of-all-substrings
    /** Algorithm
        1. The trick is to figure out how much a vowel would "help" out on left and right side.
        2. EG: "pqrabcdf" ->
            - the vowel a will be part of the LEFT substrings "ra","qra","pqra" -> so 3 LEFT substrings
            - the same wovel will be part of "ab" ,'abc", "abcd," "abcdf" -> 4 substrings RIGHT
            - also the combinations of left and right substrings (ra + [ab,abc,abcd, abcdf]) -> so 3 * 4.
            - also add 1 for the single substring.
            - total: 3 + 4 + 12 + 1.
     3. Determine and add the sum for each vowel.
     */
    private static final boolean[] VOWELS = new boolean[26];
    static {
        VOWELS[0] = VOWELS[4] = VOWELS[9] = VOWELS['o' - 'a'] = VOWELS['u' - 'a'] = true;
    }
    public long countVowels(String word) {
        long total = 0, right;
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS[word.charAt(i) - 'a']) {
                right = word.length() - i - 1;
                total += 1 + i + right + right * i;
            }
        }
        return total;
    }
}
