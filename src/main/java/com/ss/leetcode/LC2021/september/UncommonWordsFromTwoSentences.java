package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    // https://leetcode.com/problems/uncommon-words-from-two-sentences/
    /** Algorithm
        1. Get the words of each sentence (s1.split(" "));
        2. Use a single Map<String, Integer> to count the words of each sentence. If a word is unique, then its count will be 1
        3. Traverse the map and if the count is one, add it to answer.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        final List<String> uncommon = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        countWords(s1, wordCount);
        countWords(s2, wordCount);
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommon.add(entry.getKey());
            }
        }
        String[] answer = new String[uncommon.size()];
        int insertIndex = 0;
        for (String word : uncommon) {
            answer[insertIndex++] = word;
        }
        return answer;
    }

    private void countWords(String sentence, Map<String, Integer> count) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }
    }


    public String[] uncommonFromSentences2(String s1, String s2) {
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
