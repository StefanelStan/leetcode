package com.ss.leetcode.LC2022.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchSubstringAfterReplacement {
    // https://leetcode.com/contest/biweekly-contest-80/problems/match-substring-after-replacement/
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        if (sub.length() > s.length()) {
            return false;
        }
        Map<Character, Set<Character>> replacements = new HashMap<>();
        for (char[] mapping : mappings) {
            Set<Character> repls = replacements.computeIfAbsent(mapping[0], k -> new HashSet<>());
            repls.add(mapping[1]);
        }
        char[] sChars = s.toCharArray();
        char[] subChars = sub.toCharArray();
        boolean canBeReplaced = false;
        for (int i = 0; i <= sChars.length - subChars.length & !canBeReplaced; i++) {
            canBeReplaced = checkIfCanBeReplaced(sChars, subChars, i, replacements);
        }
        return canBeReplaced;
    }

    private boolean checkIfCanBeReplaced(char[] sChars, char[] subChars, int start, Map<Character, Set<Character>> replacements) {
        for (int i = 0; i < subChars.length; i++) {
            if (sChars[start + i] != subChars[i]) {
                Set<Character> repls = replacements.get(subChars[i]);
                if (repls == null || !repls.contains(sChars[start + i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
