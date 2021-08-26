package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreWordsFormedByLetters {
    // https://leetcode.com/problems/maximum-score-words-formed-by-letters/
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        List<List<String>> subsets = new ArrayList<>();
        generateAllSubsets(0, words, new ArrayList<>(), subsets);
        int maxScore = getMaxScore(subsets, letters, score);
        return maxScore;
    }

    private void generateAllSubsets(int index, String[] words, List<String> current, List<List<String>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < words.length; i++) {
            current.add(words[i]);
            generateAllSubsets(i + 1, words, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    private int getMaxScore(List<List<String>> subsets, char[] letters, int[] score) {
        int[] lettersCount = countLetters(letters);
        int maxScore = -1;
        int tempScore = -1;
        for (List<String> subset : subsets) {
            tempScore = getScoreOfSet(subset, cloneArray(lettersCount), score);
            maxScore = Math.max(tempScore, maxScore);
        }
        return maxScore;
    }

    private int[] countLetters(char[] letters) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return count;
    }

    private int[] cloneArray(int[] array) {
        int[] clone = new int[array.length];
        System.arraycopy(array, 0, clone, 0, array.length);
        return clone;
    }

    private int getScoreOfSet(List<String> subset, int[] letters, int[] score) {
        int setSum = 0, wordSum;
        for (String word : subset) {
            wordSum = 0;
            for (int i = 0; i < word.length(); i++) {
                letters[word.charAt(i) - 'a']--;
                wordSum += score[word.charAt(i) - 'a'];
                if (letters[word.charAt(i) - 'a'] < 0) {
                    wordSum = 0;
                    break;
                }
            }
            setSum += wordSum;
        }
        return setSum;
    }
}
