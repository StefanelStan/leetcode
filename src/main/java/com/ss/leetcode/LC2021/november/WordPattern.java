package com.ss.leetcode.LC2021.november;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // https://leetcode.com/problems/word-pattern/
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordLetter = new HashMap<>();
        Map<Character, String> letterWord = new HashMap<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character exChar = wordLetter.putIfAbsent(words[i], pattern.charAt(i));
            String exWord = letterWord.putIfAbsent(pattern.charAt(i), words[i]);
            if (!(exChar == null && exWord == null))
                if (exChar == null || exChar != pattern.charAt(i) || !words[i].equals(exWord)) {
                    return false;
                }
        }
        return true;
    }
}
