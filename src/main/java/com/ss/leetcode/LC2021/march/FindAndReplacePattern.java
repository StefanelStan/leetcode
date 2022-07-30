package com.ss.leetcode.LC2021.march;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    // https://leetcode.com/problems/find-and-replace-pattern/
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matches = new LinkedList<>();
        char[] pttrn = pattern.toCharArray();
        for (String word : words) {
            if (isMatchingPattern(word.toCharArray(), pttrn)) {
                matches.add(word);
            }
        }
        return matches;
    }

    private boolean isMatchingPattern(char[] word, char[] pattern) {
        char[] patternToLetter = new char[26];
        char[] matchedLetters = new char[26];
        for (int i = 0; i < word.length; i++) {
            if ((patternToLetter[pattern[i] - 'a'] != 0 && patternToLetter[pattern[i] - 'a'] != word[i])
                || (matchedLetters[word[i] - 'a'] != 0 && matchedLetters[word[i] - 'a'] != pattern[i])) {
                return false;
            }
            patternToLetter[pattern[i] - 'a'] = word[i];
            matchedLetters[word[i] - 'a'] = pattern[i];
        }
        return true;
    }

    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        final List<String> patternWords = new LinkedList<>();
        final List<Integer> analyzedPattern = analyzePattern(pattern);
        for (String word : words) {
            if (analyzedPattern.equals(analyzePattern(word))) {
                patternWords.add(word);
            }
        }
        return patternWords;
    }

    private List<Integer> analyzePattern(String word) {
        Map<Character, Integer> charIds = new HashMap<>();
        List<Integer> analyzedPattern = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            analyzedPattern.add(charIds.putIfAbsent(word.charAt(i), charIds.size()));
        }
        return analyzedPattern;
    }
}
