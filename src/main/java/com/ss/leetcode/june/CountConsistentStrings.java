package com.ss.leetcode.june;

import java.util.Set;
import java.util.TreeSet;

public class CountConsistentStrings {
    // https://leetcode.com/problems/count-the-number-of-consistent-strings/
    public int countConsistentStrings(String allowed, String[] words) {
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
