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

    /** This Algorithm Runs in O(n) time, and not O(n) * 26.
     *  Each time it adds or removes a char, it increases a sensitive count
     *  only if the original has that letter and the count goes up/down by 1
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Chars = countChars(s1);
        PermutationWindow pw = new PermutationWindow(s1Chars);
        for (int i = 0; i < s1.length(); i++) {
            pw.addChar(s2.charAt(i) - 'a');
        }
        boolean isMatching = pw.isMatching();
        for (int i = 0, j = s1.length(); !isMatching && j < s2.length(); i++, j++) {
            pw.addChar(s2.charAt(j) - 'a');
            pw.removeChar(s2.charAt(i) - 'a');
            isMatching = pw.isMatching();
        }
        return isMatching;
    }

    private int[] countChars(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    private static class PermutationWindow {
        int[] originalCount;
        int[] windowCount;
        int originalMatches = 0;
        int windowMatches;
        public PermutationWindow(int[] count) {
            originalCount = count;
            windowCount = new int[26];
            for (int j : count) {
                originalMatches += j > 0 ? 1 : 0;
            }
        }

        public void addChar(int codePoint) {
            windowCount[codePoint]++;
            if (originalCount[codePoint] > 0) {
                if (windowCount[codePoint] == originalCount[codePoint]) {
                    windowMatches++;
                } else if (windowCount[codePoint] -1 == originalCount[codePoint]) {
                    windowMatches--;
                }
            }
        }

        public void removeChar(int codePoint) {
            windowCount[codePoint]--;
            if (originalCount[codePoint] > 0) {
                if (windowCount[codePoint] == originalCount[codePoint]) {
                    windowMatches++;
                } else if (windowCount[codePoint] + 1 == originalCount[codePoint]) {
                    windowMatches--;
                }
            }
        }

        public boolean isMatching() {
            return originalMatches == windowMatches;
        }
    }
}
