package com.ss.leetcode.LC2021.november;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    // https://leetcode.com/contest/biweekly-contest-66/problems/count-common-words-with-one-occurrence/
    public int countWords(String[] words1, String[] words2) {
        int commonWords = 0;
        Map<String, Integer> words1Map = mapWords(words1);
        Map<String, Integer> words2Map = mapWords(words2);
        for (Map.Entry<String, Integer> entry : words1Map.entrySet()) {
            if (entry.getValue() == 1 && words2Map.getOrDefault(entry.getKey(), 0) == 1) {
                commonWords++;
            }
        }
        return commonWords;
    }

    private Map<String, Integer> mapWords(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.merge(word, 1, Integer::sum);
        }
        return wordsMap;
    }
}
