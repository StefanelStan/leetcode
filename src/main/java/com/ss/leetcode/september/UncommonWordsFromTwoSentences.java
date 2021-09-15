package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    // https://leetcode.com/problems/uncommon-words-from-two-sentences/
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> s1Words = mapWords(s1);
        Map<String, Integer> s2words = mapWords(s2);
        List<String> diffWords = new ArrayList<>();
        diffWords.addAll(getDifferentWords(s1Words, s2words));
        diffWords.addAll(getDifferentWords(s2words, s1Words));
        String[] result = new String[diffWords.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = diffWords.get(i);
        }
        return result;
    }

    private List<String> getDifferentWords(Map<String, Integer> words1, Map<String, Integer> words2) {
        List<String> diffWords = new ArrayList<>(words1.size()/ 2);
        for (Map.Entry<String, Integer> entry : words1.entrySet()) {
            if (entry.getValue() == 1 && !words2.containsKey(entry.getKey())) {
                diffWords.add(entry.getKey());
            }
        }
        return diffWords;
    }

    private Map<String, Integer> mapWords(String s) {
        String[] words = s.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.merge(word, 1, Integer::sum);
        }
        return wordMap;
    }
}
