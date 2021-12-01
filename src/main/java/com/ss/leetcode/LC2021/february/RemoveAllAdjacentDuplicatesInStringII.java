package com.ss.leetcode.LC2021.february;

import java.util.Arrays;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        boolean[] letters = new boolean[s.length()];
        Arrays.fill(letters, true);
        return removeDuplicates(letters, s, k);
    }

    private String removeDuplicates(boolean[] letters, String s, int k) {
        if (letters == null) {
            return "";
        }
        if (letters.length== 1) {
            return String.valueOf(s.charAt(0));
        }
        CheckStatus cs = new CheckStatus();
        boolean stillHasDuplicates = true;
        while (stillHasDuplicates) {
            stillHasDuplicates = false;
            for (int i = 0; i <= letters.length - k; ) {
                if (letters[i]) {
                    if (findAndMarkDuplicates(i, k, letters, s, cs)) {
                        stillHasDuplicates = true;
                    }
                    i = cs.index;
                } else {
                    i++;
                }
            }
        }
        final StringBuilder stb = new StringBuilder(letters.length / 10);
        for (int i = 0; i < letters.length; i++) {
            if (letters[i]) {
                stb.append(s.charAt(i));
            }
        }
        return stb.toString();
    }

    private boolean findAndMarkDuplicates(int start, int k, boolean[] letters, String s, CheckStatus cs) {
        char first = s.charAt(start);
        for (int i = start + 1; i < letters.length; i++) {
            if (letters[i]) {
                if (s.charAt(i) == first) {
                    k--;
                } else {
                    cs.index = i;
                    return false;

                }
                if (k == 1) {
                    markDuplicates(start, i, letters);
                    cs.index = Math.min(i + 1, letters.length);
                    return true;
                }
            }
        }
        // reached the end but no letters found
        cs.index = letters.length;
        return false;
    }

    private void markDuplicates(int start, int end, boolean[] letters) {
        for (int i = start; i <= end; i++) {
                letters[i] = false;
        }
    }
    private static class CheckStatus {
        private int index;
    }
}
