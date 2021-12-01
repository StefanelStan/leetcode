package com.ss.leetcode.LC2021.january;

import java.util.HashSet;
import java.util.Set;

public class StreamChecker {
    // https://leetcode.com/problems/stream-of-characters/
    private final Set<String> words = new HashSet<>();
    private final StringBuilder queryLetters = new StringBuilder();

    public StreamChecker(String[] words) {
        int currentLength = 0;
        for (String word : words) {
            this.words.add(word);
            if (word.length() > currentLength) {
                currentLength = word.length();
            }
        }
    }

    public boolean query(char letter) {
        queryLetters.append(letter);
        return verifyIfQueryExistsInWords();
    }

    private boolean verifyIfQueryExistsInWords() {
        int i = 0;
        while (i <= 25 && i < queryLetters.length()) {
            if (words.contains(queryLetters.substring(queryLetters.length() - i - 1))) {
                return true;
            }
            i++;
        }
        return false;
    }
}
