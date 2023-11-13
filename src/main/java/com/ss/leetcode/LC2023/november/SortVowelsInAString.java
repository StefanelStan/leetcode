package com.ss.leetcode.LC2023.november;

import java.util.Arrays;

public class SortVowelsInAString {
    // https://leetcode.com/problems/sort-vowels-in-a-string
    /** Algorithm
        1. You need to have the vowels into a sorted char[] vowels.
        2. Traverse s (sChars[]) and put the vowels into a StringBuilder. Get the chars[] vowels, sort and return the array.
        3. Traverse the sChars[]) and if current char is a vowel, replace it with the next available char from vowels[].
           Thus, keep an index of next available index in vowels[]
        4. Return a new string made out of the modified sChars[].
     */
    private static boolean[] vowels;
    public String sortVowels(String s) {
        initVowels();
        char[] chrs = s.toCharArray();
        char[] sortedVowels = sortVowels(chrs);
        for (int i = 0, j = 0; i < chrs.length; i++) {
            if (isVowel(chrs[i])) {
                chrs[i] = sortedVowels[j++];
            }
        }
        return new String(chrs);
    }

    private char[] sortVowels(char[] chrs) {
        StringBuilder stb = new StringBuilder();
        for (char ch : chrs) {
            if (isVowel(ch)) {
                stb.append(ch);
            }
        }
        char[] vowels = stb.toString().toCharArray();
        Arrays.sort(vowels);
        return vowels;
    }

    private boolean isVowel(char ch) {
        return vowels[ch - 'A'];
    }

    private void initVowels() {
        if (vowels == null) {
            vowels = new boolean[1 + 'z' -  'A'];
            vowels['a' - 'A'] = vowels['e' - 'A'] = vowels['i' - 'A']= vowels['o' - 'A'] = vowels['u' - 'A'] = true;
            vowels['A' - 'A'] = vowels['E' - 'A'] = vowels['I' - 'A']= vowels['O' - 'A'] = vowels['U' - 'A'] = true;
        }
    }
}
