package com.ss.leetcode.LC2022.january;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    // https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    public String findLongestWord(String s, List<String> dictionary) {
        int longest = -1;
        int tempLength = -1;
        String smallest = String.valueOf((char)('z' + 1));
        boolean found = false;
        for (String word : dictionary) {
            if (word.length() >= longest) {
                tempLength = getPossibleLength(s, word);
                if (tempLength > longest) {
                    longest = tempLength;
                    smallest = word;
                    found = true;
                } else if (tempLength == longest) {
                    smallest = getMinString(smallest, word);
                    found = true;
                }
            }
        }
        return found ? smallest : "";
    }

    private int getPossibleLength(String s, String word) {
        int sI = 0, wI = 0;
        boolean found = true;
        for (; sI < s.length() && wI < word.length(); wI++) {
            found = false;
            for(; sI < s.length(); sI++) {
                if (s.charAt(sI) == word.charAt(wI)) {
                    found = true;
                    sI++;
                    break;
                }
            }

        }
        return found && wI == word.length() ? word.length() : -2;
    }

    private String getMinString(String s1, String s2) {
        return s1.compareTo(s2) > 0 ? s2 : s1;
    }
}
