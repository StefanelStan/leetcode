package com.ss.leetcode.LC2021.may;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {
    // https://leetcode.com/problems/check-if-the-sentence-is-pangram/
    private static final int A_L = 26;
    public boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();
        for(int i = 0; i < sentence.length();i++) {
            letters.add(sentence.charAt(i));
            if(letters.size() == A_L) {
                return true;
            }
        }
        return false;
    }

    // much faster solution
    public boolean checkIfPangram2(String sentence) {
        boolean[] chars = new boolean['z' + 1];
        int unique = 0;
        for (int i = 0; i < sentence.length();i++) {
            if (!chars[sentence.charAt(i)]) {
                chars[sentence.charAt(i)] = true;
                unique++;
                if (unique == A_L) {
                    return true;
                }
            }
        }
        return false;
    }
}
