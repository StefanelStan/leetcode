package com.ss.leetcode.LC2021.september;

public class ValidAnagram {
    // https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sCount = getCount(s);
        int[] tCount = new int[26];
        int codePoint;
        for (char c: t.toCharArray()) {
            codePoint = c - 'a';
            tCount[codePoint]++;
            if (tCount[codePoint] > sCount[codePoint]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCount(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    public boolean isAnagram2(String s, String t) {
        int[] tChars = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (--tChars[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int count : tChars) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
