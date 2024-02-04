package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class MinimumWindowSubstring {
    // https://leetcode.com/problems/minimum-window-substring
    /** Algorithm
        1. If t.length > s.length return "" immediately
        2. Use a basic SlidingWindow class (and technique) to move the 2 pointers across s
        3. Map the count of each char of t into an int[1 + 'z' - 'A'].
            Also, count how many groups you have. eg: "aabbccdde" -> you have 5 groups (letters a,b,c,d,e) -> tGroups
        4. Sliding window:
            - each time you add a char, if ++sCount[char] == tCount[char] then you have matched one group.(so sGroups++)
            - when you remove a char, if sCount[char]-- == tCount[char] then you will lose a group! so sGroups--;
        5. A window is valid when your sGroups == tGroups.
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        SubstringWindow sw = initSubstringWindow(t);
        return findMinWindow(sw, s);
    }

    private String findMinWindow(SubstringWindow sw, String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0, minWindowLength = chars.length + 2;
        int windowLeft = 0, windowRight = 0;
        while (right < s.length()) {
            while(right < s.length() && !sw.isValid()) {
                sw.addLetter(chars[right++] - 'A');
            }
            while(left < right && sw.isValid()) {
                if (right - left <= minWindowLength) {
                    minWindowLength = right - left;
                    windowLeft = left;
                    windowRight = right;
                }
                sw.removeLetter(chars[left++] - 'A');
            }
        }
        return minWindowLength == chars.length + 2 ? "" : s.substring(windowLeft, windowRight);
    }

    private SubstringWindow initSubstringWindow(String t) {
        int[] tCount = new int[1 + 'z' - 'A'];
        t.codePoints().forEach(cp -> tCount[cp - 65]++);
        return new SubstringWindow(tCount);
    }

    private static class SubstringWindow {
        int[] tCount;
        int tGroups;
        int[] sCount;
        int sGroups;
        public SubstringWindow(int[] tCount) {
            this.tCount = tCount;
            tGroups = (int)Arrays.stream(tCount).filter(e -> e > 0).count();
            this.sCount = new int[1 + 'z' - 'A'];
        }

        public void addLetter(int codePoint) {
            if (tCount[codePoint] > 0 && ++sCount[codePoint] == tCount[codePoint]) {
                sGroups++;
            }
        }

        public void removeLetter(int codePoint) {
            if (tCount[codePoint] > 0 && sCount[codePoint]-- == tCount[codePoint]) {
                sGroups--;
            }
        }

        public boolean isValid() {
            return tGroups == sGroups;
        }
    }
}
