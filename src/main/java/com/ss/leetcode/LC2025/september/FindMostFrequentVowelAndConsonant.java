package com.ss.leetcode.LC2025.september;

public class FindMostFrequentVowelAndConsonant {
    // https://leetcode.com/problems/find-most-frequent-vowel-and-consonant
    /** Algorithm
        1. Use an int[26] to count each letter from string
        2. If current letter is a vowels, set the maxVowel, else set the max consonant
        3. Return the sum of max vowels and max consonant
     */
    private static final boolean[] VOWELS = new boolean[26];
    static {
        VOWELS[0] = VOWELS[4] = VOWELS[8] = VOWELS[14] = VOWELS[20] = true;
    }
    public int maxFreqSum(String s) {
        int[] letterCount = new int[26];
        int maxFreqVowel = 0, maxFreqConsonant = 0;
        int currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i) - 'a';
            letterCount[currentChar]++;
            if (VOWELS[currentChar]) {
                maxFreqVowel = Math.max(maxFreqVowel, letterCount[currentChar]);
            } else {
                maxFreqConsonant = Math.max(maxFreqConsonant, letterCount[currentChar]);
            }
        }
        return maxFreqVowel + maxFreqConsonant;
    }
}
