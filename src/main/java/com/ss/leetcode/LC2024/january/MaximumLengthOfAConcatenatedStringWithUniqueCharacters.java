package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    // https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
    /** Algorithm
        1. Filter the bad words: have duplicate letters OR anagrams. Return a List<boolean[]> words
        2. This will serve as a base DP[]. Each index will hold a Map<Integer, Integer>[].
            The map will cache the results of applying a given template over current str at index
            - eg: template "ab" over "cde"
                 template "ef" over "cde" index
        3. For each index, pick and do not pick and call next
            - pick: check if received template is compatible with current string, if yes, apply mask and
                    call with the new template and length. At the end, revert the template.
            - not pick: skip this index entirely
            - set the cache map[index].templateHash as the max between the pick and not pick
     */
    public int maxLength(List<String> arr) {
        List<boolean[]> words = getValidWords(arr);
        if (words.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer>[] concats = new Map[words.size()];
        return concatenate(0, new boolean[26], 0, concats, words);
    }

    private int concatenate(int index, boolean[] template, int length, Map<Integer, Integer>[] concats, List<boolean[]> words) {
        if (index >= words.size()) {
            return length;
        }
        if (concats[index] == null) {
            concats[index] = new HashMap<>();
        }
        int templateHash = Arrays.hashCode(template);
        Integer hashed = concats[index].get(templateHash);
        if (hashed == null) {
            // pick
            hashed = findCompatibility(template, words.get(index));
            if (hashed > 0) {
                hashed = concatenate(index + 1, template, hashed, concats, words);
                revertTemplate(template, words.get(index), 26);
            }
            //do not pick
            hashed = Math.max(hashed, concatenate(index + 1, template, length, concats, words));
            concats[index].put(templateHash, hashed);
        }
        return hashed;
    }

    private void revertTemplate(boolean[] template, boolean[] mask, int stop) {
        for (int i = 0; i < stop; i++) {
            if (mask[i]) {
                template[i] = false;
            }
        }
    }

    private int findCompatibility(boolean[] template, boolean[] mask) {
        int index = 0, score = 0;
        for (; index < 26 && (!(mask[index] && template[index])); index++) {
            if (mask[index]) {
                template[index] = true;
            }
            score += (template[index] ? 1 : 0);
        }
        if (index == 26) {
            return score;
        } else {
            revertTemplate(template, mask, index);
            return -1;
        }
    }

    private List<boolean[]> getValidWords(List<String> allWords) {
        Map<Integer, boolean[]> validWords = new HashMap<>();
        for (String word : allWords) {
            boolean[] letters = getLetters(word);
            if (letters != null) {
                validWords.put(Arrays.hashCode(letters), letters);
            }
        }
        return new ArrayList<>(validWords.values());
    }

    private boolean[] getLetters(String word) {
        boolean[] letters = new boolean[26];
        int codePoint;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            if (!(letters[codePoint] = !letters[codePoint])) {
                return null;
            }
        }
        return letters;
    }
}