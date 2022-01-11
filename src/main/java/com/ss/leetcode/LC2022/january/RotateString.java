package com.ss.leetcode.LC2022.january;

public class RotateString {
    // https://leetcode.com/problems/rotate-string/
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0) && canMatch(s, goal, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean canMatch(String s, String goal, int index) {
        for (int i = index, j = 0; j < goal.length(); j++, i++) {
            if (s.charAt(i) != goal.charAt(j)) {
                return false;
            }
            if (i == s.length() -1) {
                i = -1;
            }
        }
        return true;
    }
}
