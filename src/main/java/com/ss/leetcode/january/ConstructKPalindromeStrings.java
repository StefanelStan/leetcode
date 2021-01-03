package com.ss.leetcode.january;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    // https://leetcode.com/problems/construct-k-palindrome-strings/
    public boolean canConstruct(String s, int k) {
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
