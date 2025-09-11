package com.ss.leetcode.LC2023.november;

import java.util.Arrays;

public class SortVowelsInAString {
    // https://leetcode.com/problems/sort-vowels-in-a-string
    /** Algorithm
     1. Use an int[z + 1] vowelCount to count how many vowels there are in s
     2. Traverse S and if current char is a vowel, replace it with the first vowel from vowelCount. Keep track of current index of vowelCount
     - Decrement the vowelCount by 1 after each replacement.
     */
    private static final int[] VOWELS = new int['z' + 1];
    static {
        VOWELS['a'] = VOWELS['e'] = VOWELS['i'] = VOWELS['o'] = VOWELS['u'] = 1;
        VOWELS['A'] = VOWELS['E'] = VOWELS['I'] = VOWELS['O'] = VOWELS['U'] = 1;
    }

    public String sortVowels(String s) {
        char[] sChars = s.toCharArray();
        int[] vowelCount = getVowelCount(sChars);
        int[] vowelIndex = {0};
        for (int i = 0; i < sChars.length; i++) {
            if (VOWELS[sChars[i]] > 0) {
                sChars[i] = getNextVowel(vowelCount, vowelIndex);
            }
        }
        return new String(sChars);
    }

    private char getNextVowel(int[] vowelCount, int[] index) {
        while (vowelCount[index[0]] == 0) {
            index[0]++;
        }
        vowelCount[index[0]]--;
        return (char)index[0];

    }

    private int[] getVowelCount(char[] chars) {
        int[] count = new int['z' + 1];
        for (char c : chars) {
            count[c] += VOWELS[c];
        }
        return count;
    }


    /** Algorithm
        1. You need to have the vowels into a sorted char[] vowels.
        2. Traverse s (sChars[]) and put the vowels into a StringBuilder. Get the chars[] vowels, sort and return the array.
        3. Traverse the sChars[]) and if current char is a vowel, replace it with the next available char from vowels[].
           Thus, keep an index of next available index in vowels[]
        4. Return a new string made out of the modified sChars[].
     */
    private static boolean[] vowels;
    public String sortVowels2(String s) {
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
