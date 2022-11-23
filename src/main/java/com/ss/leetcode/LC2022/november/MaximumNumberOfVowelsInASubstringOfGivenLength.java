package com.ss.leetcode.LC2022.november;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
    /** Algorithm
        1. Flexible window: traverse from 0 to k-1 (inclusive) and count the vowels
        2. Loop from i =1, j = k.
         - if i-1 is a vowel, deduct the number of vowels by 1 (as we moved from that position)
         - if j is a vowel, increment the number of vowels
         3. Return the max number of vowels ever counted.
     */
    private static boolean[] vowels;
    public int maxVowels(String s, int k) {
        setVowels();
        int vowelCount = 0;
        int maxVowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels[s.charAt(i) - 'a']) {
                vowelCount++;
            }
        }
        maxVowelCount = Math.max(maxVowelCount, vowelCount);
        for (int i = 1, j = k; j < s.length(); i++, j++) {
            if (vowels[s.charAt(i-1) - 'a']) {
                vowelCount--;
            }
            if (vowels[s.charAt(j) - 'a']) {
                vowelCount++;
            }
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }
        return maxVowelCount;
    }

    private void setVowels() {
        if (vowels == null) {
            vowels = new boolean[26];
            vowels[0] = true;
            vowels['e' - 'a'] = true;
            vowels['i' - 'a'] = true;
            vowels['o' - 'a'] = true;
            vowels['u' - 'a'] = true;
        }
    }
}
