package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumScoreWordsFormedByLetters {
    // https://leetcode.com/problems/maximum-score-words-formed-by-letters/
    /** Algorithm
        1. Apply backtracking pick or skip over the list of words
        2. You might not be able to always pick a word if you don't have enough characters
        3. So keep track of the used characters.
        4. Each time you can pick the current word and pass the call further, remember to put the letters
            back so you can go for "skipping" options as well.
     */
    // NO MEMO - 0ms
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] charCount = getCharCount(letters);

        List<char[]> validWords = new ArrayList<>(words.length);
        for (String word : words) {
            validWords.add(word.toCharArray());
        }
        return findMaxScore(validWords, 0, charCount, score);
    }

    private int findMaxScore(List<char[]> words, int index, int[] charCount, int[] score) {
        if (index == words.size()) {
            return 0;
        }
        int selectionScore = selectScore(words.get(index), charCount, score);
        if (selectionScore > 0) {
            selectionScore += findMaxScore(words, index + 1, charCount, score);
            putBack(words.get(index), words.get(index).length - 1, charCount);
        }
        selectionScore = Math.max(selectionScore, findMaxScore(words, index + 1, charCount, score));
        return selectionScore;
    }

    private int[] getCharCount(char[] letters) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return count;
    }

    private int selectScore(char[] word, int[] charCount, int[] score) {
        int right = 0, selectionScore = 0;
        while (right < word.length && charCount[word[right] - 'a'] > 0) {
            charCount[word[right] - 'a']--;
            selectionScore += score[word[right] - 'a'];
            right++;
        }
        // if not all the letters have been selected, rollback and put them back in counter
        if (right < word.length) {
            putBack(word, right - 1, charCount);
            selectionScore = 0;
        }
        return selectionScore;
    }

    private void putBack(char[] word, int from, int[] charCount) {
        while(from >= 0) {
            charCount[word[from] - 'a']++;
            from--;
        }
    }

    // MEMO
    public int maxScoreWords2(String[] words, char[] letters, int[] score) {
        int[] charCount = getCharCount(letters);
        List<char[]> validWords = getValidWords(words, charCount, score);
        Map<Integer, Integer>[] maxScore = new Map[validWords.size()];
        return findMaxScore(validWords, 0, charCount, score, maxScore);
    }

    private int findMaxScore(List<char[]> words, int index, int[] charCount, int[] score, Map<Integer, Integer>[] maxScore) {
        if (index == words.size()) {
            return 0;
        }
        if (maxScore[index] == null) {
            maxScore[index] = new HashMap<>();
        }
        int charCountHash = Arrays.hashCode(charCount);
        Integer selectionScore = maxScore[index].get(charCountHash);
        if (selectionScore == null) {
            selectionScore = selectScore(words.get(index), charCount, score);
            if (selectionScore > 0) {
                selectionScore += findMaxScore(words, index + 1, charCount, score, maxScore);
                putBack(words.get(index), words.get(index).length - 1, charCount);
            }
            selectionScore = Math.max(selectionScore, findMaxScore(words, index + 1, charCount, score, maxScore));
            maxScore[index].put(charCountHash, selectionScore);
        }
        return selectionScore;
    }

    private List<char[]> getValidWords(String[] words, int[] charCount, int[] score) {
        List<char[]> validWords = new ArrayList<>(words.length);
        for (String word : words) {
            char[] letters = word.toCharArray();
            if (selectScore(letters, charCount, score) > 0) {
                validWords.add(letters);
                putBack(letters, letters.length - 1, charCount);
            }
        }
        return validWords;
    }



    public int maxScoreWords3(String[] words, char[] letters, int[] score) {
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
