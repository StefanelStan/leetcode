package com.ss.leetcode.LC2021.november;

public class LongestNiceSubstring {
    // https://leetcode.com/problems/longest-nice-substring/
    public String longestNiceSubstring(String s) {
        NiceSubstring ns = new NiceSubstring();
        for (int start = 0; start < s.length() - 1; start++) {
            for (int end = s.length() - 1; end > start && end - start > ns.length; end--) {
                if (isNiceSubstring(s, start, end)) {
                    ns.updateNiceSubstring(start, end);
                }
            }
        }
        if (ns.length < 1) {
            return "";
        } else {
            return s.substring(ns.start, ns.end + 1);
        }
    }

    private boolean isNiceSubstring(String s, int start, int end) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (; start <= end; start++) {
            if (s.charAt(start) >= 'a') {
                lower[s.charAt(start) - 'a'] = true;
            } else {
                upper[s.charAt(start) - 'A'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (upper[i] != lower[i]) {
                return false;
            }
        }
        return true;
    }

    private static class NiceSubstring {
        int length;
        int start;
        int end;

        public void updateNiceSubstring(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start;
        }
    }
}
