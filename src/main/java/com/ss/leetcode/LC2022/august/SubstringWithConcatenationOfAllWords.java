package com.ss.leetcode.LC2022.august;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    // https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> positions = new LinkedList<>();
        Map<String, SubstringCount> substringCount = new HashMap<>();
        int[] wordsLetterCount = new int[26];
        mapAndGetWordsLetterCount(words, substringCount, wordsLetterCount);
        int wordsLength = words.length * words[0].length();
        parseAndCountPositions(s.toCharArray(), positions, wordsLetterCount, wordsLength);

        positions.removeIf(position -> !isValidSubstring(position, s, words[0].length(), wordsLength, substringCount));
        return positions;
    }

    private void mapAndGetWordsLetterCount(String[] words, Map<String, SubstringCount> substringCount, int[] wordsLetterCount) {
        for (String word : words) {
            SubstringCount sc = substringCount.computeIfAbsent (word, k -> new SubstringCount());
            sc.maxAllowed++;
            for (char c : word.toCharArray()) {
                wordsLetterCount[c - 'a']++;
            }
        }
    }

    private void parseAndCountPositions(char[] sChars, List<Integer> positions, int[] wordsLetterCount, int wordsLength) {
        int[][] letterCount = new int[sChars.length][26];
        // set first letter
        setFirstLetter(sChars, positions, wordsLetterCount, letterCount);
        //continue with the rest of letters
        for (int i = 1; i < sChars.length; i++) {
            if (addAndCheckCount(sChars[i] - 'a', i, letterCount, wordsLetterCount, wordsLength)) {
                positions.add(i - (wordsLength -1));
            }
        }
    }

    private boolean addAndCheckCount(int codePoint, int index, int[][] letterCount, int[] wordsLetterCount, int wordsLength) {
        letterCount[index][codePoint] = letterCount[index - 1][codePoint] + 1;
        boolean countMatches = true;
        if (index >= wordsLength -1) {
            int targetLine = index - wordsLength;
            if (targetLine == -1) {
                // check with everything being equalWithCurrentLevel
                for (int i = 0; i < codePoint; i++) {
                    letterCount[index][i] = letterCount[index - 1][i];
                }
                for (int i = codePoint + 1; i < 26; i++) {
                    letterCount[index][i] = letterCount[index - 1][i];
                }
                for (int j = 0 ; j < 26; j++) {
                    if (wordsLetterCount[j] != letterCount[index][j]) {
                        countMatches = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < codePoint; i++) {
                    letterCount[index][i] = letterCount[index - 1][i];
                    if (letterCount[index][i] - letterCount[targetLine][i] != wordsLetterCount[i]) {
                        countMatches = false;
                    }
                }
                for (int i = codePoint + 1; i < 26; i++) {
                    letterCount[index][i] = letterCount[index - 1][i];
                    if (letterCount[index][i] - letterCount[targetLine][i] != wordsLetterCount[i]) {
                        countMatches = false;
                    }
                }
                if (letterCount[index][codePoint] - letterCount[targetLine][codePoint] != wordsLetterCount[codePoint]) {
                    countMatches = false;
                }
            }
        } else {
            for (int i = 0; i < codePoint; i++) {
                letterCount[index][i] = letterCount[index - 1][i];
            }
            for (int i = codePoint + 1; i < 26; i++) {
                letterCount[index][i] = letterCount[index - 1][i];
            }
            countMatches = false;
        }
        return countMatches;
    }

    private void setFirstLetter(char[] sChars, List<Integer> positions, int[] wordsLetterCount, int[][] letterCount) {
        letterCount[0][sChars[0] - 'a'] = 1;
        boolean countMatches = true;
        for (int i = 0; i < 26; i++) {
            if (letterCount[0][i] != wordsLetterCount[i]) {
                countMatches = false;
                break;
            }
        }
        if (countMatches) {
            positions.add(0);
        }
    }

    private boolean isValidSubstring(int startPos, String s, int length, int wordsSize, Map<String, SubstringCount> substringCount) {
        boolean isValid = true;
        for (int i = startPos; i < startPos + wordsSize; i+= length) {
            SubstringCount sc = substringCount.get(s.substring(i, i + length));
            if (sc == null) {
                isValid = false;
                break;
            }
            if (sc.round != startPos) {
                sc.currentPresent = 0;
                sc.round = startPos;
            }
            if (++sc.currentPresent > sc.maxAllowed) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static class SubstringCount {
        int maxAllowed;
        int round;
        int currentPresent;
    }
}
