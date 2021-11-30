package com.ss.leetcode.november;

public class FindTheDifference {
    // https://leetcode.com/problems/find-the-difference/
    public char findTheDifference(String s, String t) {
        int[] sCharCount = countChars(s);
        int[] tCharCount = new int[26];
        int pos;
        char extra = 'a';
        for (int i = 0; i < t.length(); i++) {
            pos = t.charAt(i) - 'a';
            tCharCount[pos]++;
            if (tCharCount[pos] > sCharCount[pos]) {
                extra = t.charAt(i);
                break;
            }
        }
        return extra;
    }

    private int[] countChars(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
