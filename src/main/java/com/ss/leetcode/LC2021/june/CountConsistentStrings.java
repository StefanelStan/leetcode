package com.ss.leetcode.LC2021.june;

import java.util.Set;
import java.util.TreeSet;

public class CountConsistentStrings {
    // https://leetcode.com/problems/count-the-number-of-consistent-strings/
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] present = new boolean[26];
        int count = 0;
        for (int i = 0; i < allowed.length(); i++) {
            present[allowed.charAt(i) - 'a'] = true;
        }
        boolean isConsistent;
        for (String word : words) {
            isConsistent = true;
            for (int i = 0; i < word.length() && isConsistent; i++) {
                isConsistent = present[word.charAt(i) - 'a'];
            }
            count += isConsistent ? 1 : 0;
        }
        return count;
    }


    public int countConsistentStrings2(String allowed, String[] words) {
        Set<Integer> allowedChars = new TreeSet<>();
        int consistentStrings = 0;
        for (int i = 0; i < allowed.length(); i++) {
            allowedChars.add((int)allowed.charAt(i));
        }
        for (String word: words) {
            if(isAllowedWord(allowedChars, word)) {
                consistentStrings++;
            }
        }

        return consistentStrings;
    }

    private boolean isAllowedWord(Set<Integer> allowedChars, String word) {
        boolean isAllowed = true;
        for (int i = 0; i < word.length(); i++) {
            if (!allowedChars.contains((int) word.charAt(i))) {
                isAllowed = false;
                break;
            }
        }
        return isAllowed;
    }
}
