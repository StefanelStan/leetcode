package com.ss.leetcode.july;

public class LongestCommonPrefix {
    // https://leetcode.com/problems/longest-common-prefix/
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stb = new StringBuilder();
        char currentChar = 0;
        int minStrLength = strs[0].length();
        boolean foundInLoop = true;
        for (int i = 0; i < minStrLength && foundInLoop; i++) {
            currentChar = strs[0].charAt(i);
            foundInLoop = true;
            for (String str : strs) {
                if (str.length() < minStrLength) {
                    minStrLength = str.length();
                }
                if (minStrLength == 0 || str.charAt(i) != currentChar) {
                    foundInLoop = false;
                    break;
                }
            }
            if (foundInLoop) {
                stb.append(currentChar);
            }
        }
        return stb.toString();
    }
}
