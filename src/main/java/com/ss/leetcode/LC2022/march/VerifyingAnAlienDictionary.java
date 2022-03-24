package com.ss.leetcode.LC2022.march;

public class VerifyingAnAlienDictionary {
    // https://leetcode.com/problems/verifying-an-alien-dictionary/
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        int[] alphabet = getAlphabet(order);
        for (int i = 0; i < words.length -1; i++) {
            if(!isInOrder(words[i], words[i + 1], alphabet)) {
                return false;
            }
        }
        return true;
    }

    private int[] getAlphabet(String order) {
        int[] alphabet = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }
        return alphabet;
    }

    private boolean isInOrder(String s1, String s2, int[] alphabet) {
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (alphabet[s1.charAt(i) - 'a'] < alphabet[s2.charAt(j) - 'a']) {
                return true;
            } else if (alphabet[s1.charAt(i) - 'a'] > alphabet[s2.charAt(j) - 'a']) {
                return false;
            }
        }
        return s1.length() <= s2.length();
    }
}
