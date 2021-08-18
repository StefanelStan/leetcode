package com.ss.leetcode.august;

public class NumberOfLinesToWriteString {
    // https://leetcode.com/problems/number-of-lines-to-write-string/
    public int[] numberOfLines(int[] widths, String s) {
        int numberOfLines = 1;
        int partialSum = 0;
        for (char c: s.toCharArray()) {
            partialSum += widths[c - 'a'];
            if (partialSum > 100) {
                numberOfLines++;
                partialSum = widths[c - 'a'];
            }
        }
        return partialSum == 0 ? new int[] { numberOfLines - 1, 0 } : new int[] { numberOfLines, partialSum };
    }
}
