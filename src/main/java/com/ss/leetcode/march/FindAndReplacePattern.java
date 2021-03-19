package com.ss.leetcode.march;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
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
