package com.ss.leetcode.LC2022.january;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestWordInDictionary {
    // https://leetcode.com/problems/longest-word-in-dictionary/
    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(w -> w.length()));
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);
        boolean found;
        PriorityQueue<String> foundWords = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = words.length - 1; i >= 0; i--) {
            found = true;
            if (!foundWords.isEmpty() && words[i].length() < foundWords.peek().length()) {
                break;
            }
            if (words[i].length() == 1) {
                foundWords.add(words[i]);
                if (foundWords.size() == 2) {
                    foundWords.poll();
                }
            } else {
                for (int j = words[i].length(); j >= 1; j--) {
                    if (!wordSet.contains(words[i].substring(0, j))) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    foundWords.add(words[i]);
                    if (foundWords.size() == 2) {
                        foundWords.poll();
                    }
                }
            }
        }
        if (foundWords.isEmpty()) {
            return "";
        }
        return foundWords.peek();
    }
}
