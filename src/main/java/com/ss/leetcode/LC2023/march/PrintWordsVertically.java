package com.ss.leetcode.LC2023.march;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    // https://leetcode.com/problems/print-words-vertically
    /** Algorithm
        1. Split the s into words delimited by space
        2. After the split, iterate over them and find the longest word. This would give us the number of columns.
        3. Iterate from 0 to numberOfColumns and for each word get the char position at that columnIndex.
            If columnIndex >= word.length(), return space.
        4. For each step, store the result into a stringBuilder and remove any ending/trailing spaces.
     */
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLength = getMaxLength(words);
        List<String> vertical = new ArrayList<>(maxLength);
        for (int i = 0; i < maxLength; i++) {
            vertical.add(getVerticalString(words, i, maxLength));
        }
        return vertical;
    }

    private int getMaxLength(String[] chunks) {
        int max = 0;
        for (String s : chunks) {
            max = Math.max(s.length(), max);
        }
        return max;
    }

    private String getVerticalString(String[] chunks, int position, int maxLength) {
        StringBuilder stb = new StringBuilder();
        for (String s : chunks) {
            // if the columnIndex is greater than the word length, append space
            stb.append(position >= s.length() ? ' ' : s.charAt(position));
        }
        // remove trailing spaces
        int lastNonSpace = stb.length() -1;
        while(lastNonSpace >= 0 && stb.charAt(lastNonSpace) == ' ') {
            lastNonSpace--;
        }
        stb.setLength(lastNonSpace + 1);
        return stb.toString();
    }
}
