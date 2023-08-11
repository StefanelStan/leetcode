package com.ss.leetcode.LC2021.february;

import java.util.LinkedList;
import java.util.List;

public class ReplaceTheSubstringForBalancedString {
    // https://leetcode.com/problems/replace-the-substring-for-balanced-string/
    // Found the solution after 2 1/2 years :)
    public int balancedString(String s) {
        char[] chrs = s.toCharArray();
        NeededCharWindow ncw = new NeededCharWindow(chrs);
        if (ncw.containsAllNeededChars()) {
            return 0;
        }
        int smallestNeededWindow = chrs.length;
        int left = 0, right = 0;
        while(left < chrs.length) {
            if (right == s.length() && !ncw.containsAllNeededChars()) {
                break;
            }
            if (!ncw.containsAllNeededChars()) {
                ncw.offerCharacter(chrs[right] - 'A');
                right++;
            } else {
                smallestNeededWindow = Math.min(smallestNeededWindow, ncw.windowSize);
                if (smallestNeededWindow == ncw.totalNeededChars) {
                    break;
                }
                ncw.pollCharacter(chrs[left] - 'A');
                left++;
            }
        }
        return smallestNeededWindow;
    }

    private static class NeededCharWindow {
        private int[] window;
        private int[] neededChars;
        private int neededGroups;
        private int windowSize;
        private int totalNeededChars;

        public NeededCharWindow(char[] s) {
            window = new int[26];
            getNeededChars(s);
        }

        private void getNeededChars(char[] s) {
            int[] charCount = countChars(s);
            neededChars = new int[26];
            int average = s.length / 4;
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] > average) {
                    neededChars[i] = charCount[i] - average;
                    totalNeededChars += neededChars[i];
                    neededGroups++;
                }
            }
        }

        public void offerCharacter(int codePoint) {
            windowSize++;
            if (neededChars[codePoint] == ++window[codePoint] && neededChars[codePoint] > 0) {
                neededGroups--;
            }
        }

        public void pollCharacter(int codePoint) {
            windowSize--;
            if (neededChars[codePoint] == window[codePoint]-- && neededChars[codePoint] > 0) {
                neededGroups++;
            }
        }

        private int[] countChars(char[] s) {
            int[] count = new int[26];
            for (char c : s) {
                count[c - 'A']++;
            }
            return count;
        }

        public boolean containsAllNeededChars() {
            return neededGroups == 0;
        }
    }


    public int balancedString2(String s) {
        List<Integer> qp = new LinkedList<>();
        List<Integer> wp = new LinkedList<>();
        List<Integer> ep = new LinkedList<>();
        List<Integer> rp = new LinkedList<>();

        traverseStringAndCountLetters(s, qp, wp, ep, rp);

        if(qp.size() == wp.size() && wp.size() == ep.size() && ep.size() == rp.size()) {
            return 0;
        }

        return 1;
    }

    private void traverseStringAndCountLetters(String s, List<Integer> qPositions, List<Integer> wPositions,
                                               List<Integer> ePositions, List<Integer> rPositions) {

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'Q' -> qPositions.add(i);
                case 'W' -> wPositions.add(i);
                case 'E' -> ePositions.add(i);
                case 'R' -> rPositions.add(i);
                default -> throw new RuntimeException("Invalid character detected!");
            }
        }
    }
}
