package com.ss.leetcode.LC2022.january;

public class ShortestCompletingWord {
    // https://leetcode.com/problems/shortest-completing-word/
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[][] wordsMap = getWordsMap(words);
        int[] licenseLetters = getLicensePlate(licensePlate);
        int shortest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (containsFullPlate(licenseLetters, wordsMap[i])) {
                if (words[i].length() < shortest) {
                    shortest = words[i].length();
                    index = i;
                }
            }
        }
        return words[index];
    }

    private int[][] getWordsMap(String[] words) {
        int[][] wordsMap = new int[words.length][26];
        for(int i = 0; i < words.length; i++) {
            for (int j =0; j < words[i].length(); j++) {
                wordsMap[i][words[i].charAt(j) - 'a']++;
            }
        }
        return wordsMap;
    }


    private int[] getLicensePlate(String word) {
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                count[word.charAt(i) - 'a']++;
            } else if (word.charAt(i) >= 'A') {
                count[word.charAt(i) - 'A']++;
            }
        }
        return count;
    }

    private boolean containsFullPlate(int[] license, int[] word) {
        for(int i = 0; i < license.length; i++) {
            if (license[i] > word[i]) {
                return false;
            }
        }
        return true;
    }
}
