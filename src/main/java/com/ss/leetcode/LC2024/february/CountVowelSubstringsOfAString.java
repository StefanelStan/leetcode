package com.ss.leetcode.LC2024.february;

public class CountVowelSubstringsOfAString {
    // https://leetcode.com/problems/count-vowel-substrings-of-a-string
    /** Algorithm
        1. Map the vowels onto an boolean[26].
        2. For each index i (0, n-4), loop with j from i to end or until you hot a consonant.
        3. With each index and loop of j, if you have 5 diff vowels, increase the substring count.
     */
    private static final boolean[] vowels = new boolean[26];
    static {
        vowels[0] = vowels[4] = vowels[8] = vowels['o' - 'a'] = vowels['u' - 'a'] = true;
    }
    public int countVowelSubstrings(String word) {
        int substringCount = 0, groupCount;
        int[] count;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 4; i++) {
            groupCount = 0;
            count = new int[26];
            for (int j = i; j < chars.length && vowels[chars[j] - 'a']; j++) {
                if (++count[chars[j] - 'a'] == 1) {
                    groupCount++;
                }
                substringCount += groupCount == 5 ? 1 : 0;
            }
        }
        return substringCount;
    }
}
