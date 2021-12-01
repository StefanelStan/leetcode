package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class CustomSortString {
    // https://leetcode.com/problems/custom-sort-string/
    public String customSortString(String order, String str) {
        final int[] charToPosition = new int[26];
        fillUpPositions(order, charToPosition);
        final int[] charCount = countChars(str);
        final char[] sortedChars = sortString(order, str, charToPosition, charCount);
        return new String(sortedChars);
    }

    private void fillUpPositions(String order, int[] charToPosition) {
        Arrays.fill(charToPosition, -1);
        for (int i = 0; i < order.length(); i++) {
            charToPosition[order.charAt(i) - 'a'] = i;
        }
    }

    private int[] countChars(String str) {
        final int[] charCount = new int[26];
        for (int i = 0; i <str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        return charCount;
    }

    private char[] sortString(String order, String str, int[] charToPosition, int[] charCount) {
        final char[] sortedChars = new char[str.length()];
        int insertIndex = 0;
        for (int i = 0; i < order.length(); i++) {
            Arrays.fill(sortedChars, insertIndex, insertIndex + charCount[order.charAt(i) - 'a'], order.charAt(i));
            insertIndex += charCount[order.charAt(i) - 'a'];
        }
        // if we have chars that are not in the "sorting dictionary" insert them at the end
        if (insertIndex < str.length()) {
            for (int i = 0; i < charCount.length; i++) {
                if (charToPosition[i] == -1) {
                    Arrays.fill(sortedChars, insertIndex, insertIndex + charCount[i], (char)(i + 'a'));
                    insertIndex += charCount[i];
                }
            }
        }
        return sortedChars;
    }
}

