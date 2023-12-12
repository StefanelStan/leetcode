package com.ss.leetcode.LC2021.january;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    // https://leetcode.com/problems/construct-k-palindrome-strings/
    public boolean canConstruct(String s, int k) {
        CharCount charCount = getCharCount(s);
        return k >= charCount.oddTotalGroups &&
            k - charCount.oddTotalGroups <= charCount.evenTotalChars + Math.max(0, charCount.oddTotalChars - charCount.oddSingleChars);
    }

    private CharCount getCharCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        CharCount charCount = new CharCount();
        for (int c : count) {
            if (c % 2 == 0) {
                charCount.evenTotalChars += c;
            } else {
                charCount.oddTotalGroups++;
                charCount.oddTotalChars += c;
                charCount.oddSingleChars += (c > 1 ? 0 : c);
            }
        }
        return charCount;
    }

    private static class CharCount {
        int oddTotalGroups;
        int oddSingleChars;
        int oddTotalChars;
        int evenTotalChars;
    }

    public boolean canConstruct2(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        Map<Character, Integer> letterCount = new HashMap<>();
        Map<Integer, Integer> letterCardinals = new HashMap<>();

        for(char c: s.toCharArray()) {
            letterCount.merge(c, 1, Integer::sum);
        }

        letterCount.values().forEach(value -> letterCardinals.merge(value, 1, Integer::sum));
        final int[] pairsOfOne = {0};
        final int[] evenLetters = {0};
        final int[] oddLetters = {0};
        letterCardinals.forEach((key, value) -> {
            if (key == 1) {
                pairsOfOne[0] = value;
            } else if (key % 2 == 0) {
                evenLetters[0]++;
            } else {
                oddLetters[0]++;
            }
        });

        int maxNumberOfPalindromes = pairsOfOne[0] + evenLetters[0] + evenLetters[0];
        return maxNumberOfPalindromes >= k;
    }
}
