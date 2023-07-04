package com.ss.leetcode.LC2023.july;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsInWraparoundString {
    // Needs DP
    public int findSubstringInWraproundString(String s) {
        StringBuilder stb = new StringBuilder();
        Set<String> unique = new HashSet<>();
        char prev = 0, current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (!areConsecutive(prev, current)) {
                extractUniqueSubstrings(stb, unique);
                stb.setLength(0);
            }
            prev = current;
            stb.append(current);
        }
        extractUniqueSubstrings(stb, unique);
        return unique.size();
    }

    private boolean areConsecutive(char first, char second) {
        return first + 1 == second || first - 25 == second;
    }

    private void extractUniqueSubstrings(StringBuilder stb, Set<String> unique) {
        for (int size = 1; size <= stb.length(); size++) {
            for (int i = 0; i <= stb.length() - size; i++) {
                unique.add(stb.substring(i, i + size));
            }
        }
    }
}
