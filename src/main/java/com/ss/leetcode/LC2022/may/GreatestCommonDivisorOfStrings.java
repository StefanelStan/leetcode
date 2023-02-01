package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class GreatestCommonDivisorOfStrings {
    // https://leetcode.com/problems/greatest-common-divisor-of-strings/
    public String gcdOfStrings(String str1, String str2) {
        char[] shortChars = str1.length() <= str2.length() ? str1.toCharArray() : str2.toCharArray();
        char[] longChars = str1.length() <= str2.length() ? str2.toCharArray() : str1.toCharArray();

        if (longChars.length % shortChars.length == 0 && isDividable (shortChars, shortChars.length -1, longChars)) {
            return str1.length() <= str2.length() ? str1 : str2;
        }
        for (int i = shortChars.length /2; i >= 0; i--) {
            if ((shortChars.length % (i + 1) == 0 && longChars.length % (i + 1) == 0)
                && isDividable(shortChars, i, shortChars) && isDividable(shortChars, i, longChars)) {
                return new String(Arrays.copyOf(shortChars, i + 1));
            }
        }
        return "";
    }

    private boolean isDividable(char[] source, int end, char[] target) {
        for (int window = 0; window +end < target.length; window += end + 1) {
            for (int i = 0; i <= end; i++) {
                if (source[i] != target[i+window]) {
                    return false;
                }
            }
        }
        return true;
    }


    public String gcdOfStrings2(String str1, String str2) {
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
