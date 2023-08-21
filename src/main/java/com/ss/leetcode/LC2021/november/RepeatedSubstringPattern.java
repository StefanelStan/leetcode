package com.ss.leetcode.LC2021.november;

public class RepeatedSubstringPattern {
    // https://leetcode.com/problems/repeated-substring-pattern/
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        boolean canRepeat = false;
        for (int i = 1; i <= chars.length / 2 && !canRepeat; i++) {
            if (chars.length % i == 0) {
                canRepeat = checkIfCanRepeat(chars, i);
            }
        }
        return canRepeat;
    }

    private boolean checkIfCanRepeat(char[] chars, int stop) {
        for (int j = stop; j < chars.length; j += stop) {
            for (int i = 0; i < stop; i++) {
                if (chars[i] != chars[j + i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s.length() == 1) {
            return false;
        }
        for (int i = 1; i <= s.length() /2; i++) {
            if (s.charAt(0) == s.charAt(i)) {
                if (isSubseqRepeated(s,i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSubseqRepeated(String s, int firstIndex) {
        if (s.length() % firstIndex != 0) {
            return false;
        }
        for (int order = 0; order < firstIndex; order++) {
            for (int round = order + firstIndex; round < s.length(); round += firstIndex) {
                if (s.charAt(order) != s.charAt(round)) {
                    return false;
                }
            }
        }
        return true;
    }
}
