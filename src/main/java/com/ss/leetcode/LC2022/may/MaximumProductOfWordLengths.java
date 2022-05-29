package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductOfWordLengths {
    // https://leetcode.com/problems/maximum-product-of-word-lengths/
    public int maxProduct(String[] words) {
        Word[] wordProperties = new Word[words.length];
        for(int i = 0; i < words.length; i++) {
            wordProperties[i] = getWordProperty(words[i]);
        }
        Arrays.sort(wordProperties, Comparator.comparingInt(wp -> wp.length));
        int maxProduct = 0;
        for (int i = wordProperties.length - 1; i > 0; i--) {
            for (int j = i - 1; j >=0 && wordProperties[j].length * wordProperties[i].length > maxProduct; j--) {
                if (!wordProperties[i].hasCommonLetters(wordProperties[j])) {
                    maxProduct = wordProperties[j].length * wordProperties[i].length;
                    break;
                }
            }
        }
        return maxProduct;
    }

    private Word getWordProperty(String word) {
        boolean[] chars = new boolean[26];
        for(char c : word.toCharArray()) {
            chars[c - 'a'] = true;
        }
        return new Word(chars, word.length());
    }

    private static class Word {
        boolean[] chars;
        int length;

        public Word(boolean[] chars, int length) {
            this.chars = chars;
            this.length = length;
        }

        public boolean hasCommonLetters(Word other) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] && other.chars[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}
