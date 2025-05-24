package com.ss.leetcode.LC2025.may;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    /** Algorithm
        1. For each word in words
            - traverse the word and check if current letter matches given letter
            - if yes, break and add current word index to answer
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }
}
