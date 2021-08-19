package com.ss.leetcode.august;

public class FindWordsFormedByCharacters {
    // https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
    public int countCharacters(String[] words, String chars) {
        int countWords = 0;
        int[] charCount = getCharCount(chars);
        for(String word : words) {
            countWords += getValidWordLength(word, charCount);
        }
        return countWords;
    }

    private int[] getCharCount(String chars) {
        int[] charCount = new int['z' - 'a' + 1];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i)- 'a']++;
        }
        return charCount;
    }

    private int getValidWordLength(String word, int[] charCount) {
        int[] wordChars =  new int[26];
        int currentChar;
        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i) - 'a';
            wordChars[currentChar]++;
            if (wordChars[currentChar] > charCount[currentChar]) {
                return 0;
            }
        }
        return word.length();
    }
}
