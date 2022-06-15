package com.ss.leetcode.LC2021.january;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LongestStringChain {
    // https://leetcode.com/problems/longest-string-chain/
    public int longestStrChain(String[] words) {
        if (words.length == 1) {
            return 1;
        }
        int[] lengthStart = new int[18];
        Arrays.fill(lengthStart, -1);
        Arrays.sort(words, Comparator.comparingInt(word -> word.length()));
        int[] maxLengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (lengthStart[words[i].length()] == -1) {
                lengthStart[words[i].length()] = i;
            }
        }
        for (int i = 0; i < lengthStart[words[words.length -1].length()]; i++) {
            if (lengthStart[words[i].length() + 1] != -1) {
                searchAndMakeChain(words, i, lengthStart[words[i].length() + 1], maxLengths);
            }
        }
        int max = 1;
        for (int length : maxLengths) {
            max = Math.max(max, length);
        }
        return max;
    }

    private boolean canMakeChain(char[] s1, char[] s2) {
        boolean skippedOnce = false;
        for (int i = 0, j = 0; i < s1.length && j < s2.length;) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                if (skippedOnce) {
                    return false;
                } else {
                    skippedOnce = true;
                    j++;
                }
            }
        }
        return true;
    }

    private void searchAndMakeChain(String[] words, int wIndex, int startIndex, int[] maxLengths) {
        char[] word = words[wIndex].toCharArray();
        for (int i = startIndex; i < words.length && words[i].length() == words[startIndex].length(); i++) {
            if (canMakeChain(word, words[i].toCharArray())) {
                if (maxLengths[wIndex] == 0) {
                    maxLengths[wIndex] = 1;
                    maxLengths[i] = Math.max(2, maxLengths[i]);
                } else {
                    maxLengths[i] = Math.max(maxLengths[i] , maxLengths[wIndex] + 1);
                }
            }
        }
    }

    public int longestStrChain2(String[] words) {
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
