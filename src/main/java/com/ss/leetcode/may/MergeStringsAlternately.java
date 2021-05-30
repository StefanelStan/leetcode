package com.ss.leetcode.may;

public class MergeStringsAlternately {
    // https://leetcode.com/problems/merge-strings-alternately/
    public String mergeAlternately(String word1, String word2) {
        String shortString = word1.length() < word2.length() ? word1 : word2;
        String longString = word1.length() < word2.length() ? word2 : word1;
        // much memory efficient than using StringBuilder
        char[] result = new char[word1.length() + word2.length()];
        for (int i = 0, j = 0; i < shortString.length();i++, j+=2) {
            result[j] = word1.charAt(i);
            result[j+1] = word2.charAt(i);
        }
        for (int i = shortString.length(), j = i * 2; i < longString.length(); i++, j++) {
            result[j] = longString.charAt(i);
        }
        return new String(result);
    }
}
