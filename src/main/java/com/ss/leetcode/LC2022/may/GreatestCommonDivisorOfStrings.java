package com.ss.leetcode.LC2022.may;

import java.util.Deque;
import java.util.LinkedList;

public class GreatestCommonDivisorOfStrings {
    // https://leetcode.com/problems/greatest-common-divisor-of-strings/
    public String gcdOfStrings(String str1, String str2) {
        char[] longChars = str1.length() < str2.length() ? str2.toCharArray() : str1.toCharArray();
        char[] shortChars = str1.length() >= str2.length() ? str2.toCharArray() : str1.toCharArray();

        Deque<Integer> divisorIndices = new LinkedList<>();
        for (int i = 0; i < shortChars.length; i++) {
            if (longChars[i] == shortChars[i]) {
                if (shortChars.length % (i + 1) == 0 && longChars.length % (i + 1) == 0) {
                    divisorIndices.addLast(i);
                }
            } else {
                return "";
            }
        }
        while (!divisorIndices.isEmpty()) {
            int length = divisorIndices.removeLast();
            if (isGCD(length, longChars, shortChars)) {
                return str1.substring(0, length + 1);
            }
        }
        return "";
    }

    private boolean isGCD(int length, char[] longChars, char[] shortChars) {
        return isRepeatableSubsequence(length, longChars) && isRepeatableSubsequence(length, shortChars);
    }

    private boolean isRepeatableSubsequence(int length, char[] chars) {
        for (int i = length + 1; i + length < chars.length; i += (length + 1)) {
            for (int j = 0; j <= length; j++) {
                if (chars[i + j] != chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
