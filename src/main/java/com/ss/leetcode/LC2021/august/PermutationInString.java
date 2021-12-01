package com.ss.leetcode.LC2021.august;

public class PermutationInString {
    // https://leetcode.com/problems/permutation-in-string/
    public boolean checkInclusion(String s1, String s2) {
        boolean isIncluded = false;
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Chars = countChars(s1, 0, s1.length() - 1);
        int[] s2Chars = countChars(s2, 0, s1.length() - 1);
        if (areArraysEqual(s1Chars, s2Chars)) {
            return true;
        }
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            s2Chars[s2.charAt(i - 1) - 'a']--;
            s2Chars[s2.charAt(i + s1.length() - 1) - 'a']++;
            if (areArraysEqual(s1Chars, s2Chars)) {
                isIncluded = true;
                break;
            }
        }
        return isIncluded;
    }

    private int[] countChars(String s1, int start, int stopInclusive) {
        int[] countChars = new int[26];
        for (; start <= stopInclusive; start++) {
            countChars[s1.charAt(start) - 'a']++;
        }
        return countChars;
    }

    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
