package com.ss.leetcode.LC2023.september;

import java.util.ArrayList;
import java.util.List;

public class ImplementMagicDictionary {
    /** Algorithm
        1. Use a List<char[]>[] to store the char arrays for each string on its own size bucket.
            It's faster to search through char[] than string
        2. Based on each word dictionary length, add its char[] to the correct bucket
        3. For the given searchWord, look inside the bucket. If it's empty, return false immediately.
        4. Else, for each char[] in the bucket try to compare each char at a time against the search word.
            If one doesn't match, ignore it. If two don't match, break and swap to next word in the bucket.
     */
    private final List<char[]>[] words;
    public ImplementMagicDictionary() {
        words = new List[101];
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            if (words[word.length()] == null) {
                words[word.length()] = new ArrayList<>();
            }
            words[word.length()].add(word.toCharArray());
        }
    }

    public boolean search(String searchWord) {
        List<char[]> possibleWords = words[searchWord.length()];
        if (possibleWords == null) {
            return false;
        }
        char[] chars = searchWord.toCharArray();
        boolean swapUsed;
        for (char[] word : possibleWords) {
            swapUsed = false;
            for (int i = 0; i < chars.length; i++) {
                if (word[i] != chars[i]) {
                    swapUsed = !swapUsed;
                    if (!swapUsed) {
                        break;
                    }
                }
            }
            if (swapUsed) {
                return true;
            }
        }
        return false;
    }
}
