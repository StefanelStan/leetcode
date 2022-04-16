package com.ss.leetcode.LC2021.july;

public class ImplementStrStr {
    // https://leetcode.com/problems/implement-strstr/
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] haystackC = haystack.toCharArray();
        char[] needleC = needle.toCharArray();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystackC[i] == needleC[0] && isFound(haystackC, needleC, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFound (char[] haystack, char[] needle, int start) {
        for (int i = 0; i < needle.length; i++) {
            if (haystack[start + i] != needle[i]) {
                return false;
            }
        }
        return true;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int strStr = -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && isNeedlePresent(haystack, needle, i)) {
                return i;
            }
        }
        return strStr;
    }

    private boolean isNeedlePresent(String haystack, String needle, int i) {
        for (int needleIndex = 0; needleIndex < needle.length() && i + needleIndex < haystack.length(); needleIndex++) {
            if (haystack.charAt(i + needleIndex) != needle.charAt(needleIndex)) {
                return false;
            }
        }
        return true;
    }
}
