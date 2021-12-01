package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> positions = new ArrayList<>();
        if (p.length() > s.length()) {
            return positions;
        }
        int[] pChars = countChars(p, p.length());
        int[] sChars = countChars(s, p.length());
        if (areEqual(sChars, pChars)) {
            positions.add(0);
        }
        for (int start = 1, end = start + p.length() -1; end < s.length(); start++, end++) {
            sChars[s.charAt(start -1) - 'a']--;
            sChars[s.charAt(end) - 'a']++;
            if (areEqual(sChars, pChars)) {
                positions.add(start);
            }
        }
        return positions;
    }

    private int[] countChars(String s, int end) {
        int[] positions = new int[26];
        for (int i = 0; i < end; i++) {
            positions[s.charAt(i) - 'a']++;
        }
        return positions;
    }

    private boolean areEqual(int[] first, int[] second) {
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
}
