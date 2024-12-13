package com.ss.leetcode.LC2024.december;

public class VowelsGameInAString {
    // https://leetcode.com/problems/vowels-game-in-a-string
    /** Algorithm
        1. No matter how Alice plays, she needs to have at least 1 vowel in the original string.
        2. If string has odd number of vowels, she can eliminate the whole string, leaving bob without move
        3. If string has even number, she can eliminate k - 1 vowels, so bob can only eliminate consonants (or no move).
            - If bob eliminates a consonant, Alice will remove the rest of the string (which has 1 vowel)
     */
    private static final int[] vowels = new int[26];
    static {
        vowels[0] = vowels[4] = vowels['i' - 'a'] = vowels['o' - 'a'] = vowels['u' - 'a'] = 1;
    }
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for (int i = 0; i < s.length(); i++) {
            vowelCount += vowels[s.charAt(i) - 'a'];
        }
        return vowelCount >= 1;
    }
}
