package com.ss.leetcode.may;

public class ShuffleString {
    // https://leetcode.com/problems/shuffle-string/submissions/
    public String restoreString(String s, int[] indices) {
        char[] restoredString = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            restoredString[indices[i]] = s.charAt(i);
        }
        return new String(restoredString);
    }
}
