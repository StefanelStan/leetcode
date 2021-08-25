package com.ss.leetcode.august;

public class NumberOfStringAsSubstringsInWord {
    // https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
    public int numOfStrings(String[] patterns, String word) {
        int numberOfSubstrings = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                numberOfSubstrings++;
            }
        }
        return numberOfSubstrings;
    }
}
