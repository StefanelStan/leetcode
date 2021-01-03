package com.ss.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LongestStringChain {
    // https://leetcode.com/problems/longest-string-chain/
    public int longestStrChain(String[] words) {
        NavigableMap<Integer, List<String>> lenghtOfWords = putWordsIntoMap(words);
        Map<String, Integer> longestChain = new HashMap<>();

        detectLongestChainsInWords(longestChain, lenghtOfWords);

        return longestChain.values().stream().mapToInt(v -> v).max().orElse(1);
    }

    private NavigableMap<Integer, List<String>> putWordsIntoMap(String[] words) {
        NavigableMap<Integer, List<String>> lengthToChars = new TreeMap<>();
        for (String word : words) {
            List<String> list = lengthToChars.get(word.length());
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(word);
            lengthToChars.putIfAbsent(word.length(), list);
        }
        return lengthToChars;
    }


    private void detectLongestChainsInWords(Map<String, Integer> longestChain, NavigableMap<Integer, List<String>> lenghtOfWords) {
        lenghtOfWords.forEach((length, words) -> {
            if (length == 1) {
                words.forEach(word -> longestChain.put(word, 1));
            } else {
                words.forEach(word -> {
                    findLongestSubchain(word, longestChain, lenghtOfWords);
                });
            }

        });

    }

    private void findLongestSubchain(String word, Map<String, Integer> longestChain,
                                     NavigableMap<Integer, List<String>> lenghtOfWords) {
        List<String> subwords = lenghtOfWords.get(word.length() -1);
        if(subwords == null || subwords.isEmpty()) {
            longestChain.put(word, 1);
            return;
        } else {
            // detect if subword is part of word and if yes, get maxValue and set it to longestChain.
            final int[] maxLength = {0};
            subwords.forEach(subword -> {
                if(isSubword(word, subword)) {
                    maxLength[0] = Math.max(maxLength[0], longestChain.get(subword));
                }
            });
            longestChain.put(word, 1 + maxLength[0]);
        }
    }

    private boolean isSubword(String word, String subword) {
        boolean skippedOnce = false;
        for(int i = 0, j = 0; i < word.length() && j < subword.length(); i++, j++) {
            if(word.charAt(i) !=  subword.charAt(j)) {
                if(!skippedOnce) {
                    skippedOnce = true;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
