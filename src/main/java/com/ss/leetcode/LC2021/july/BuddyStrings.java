package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class BuddyStrings {
    // https://leetcode.com/problems/buddy-strings/
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        int[] sChars = new int['z' + 1];
        int[] goalChars = new int['z' + 1];
        int sMaxChar = countCharsAndGetMax(s, sChars);
        countCharsAndGetMax(goal, goalChars);
        if (s.equals(goal)) {
            return sMaxChar > 1;
        }
        int mismatchPositions = getMismatchPositions(s, goal);
        if(mismatchPositions > 2) {
            return false;
        } else return Arrays.equals(sChars, goalChars);
    }

    private int getMismatchPositions(String s, String goal) {
        int mismatches = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                mismatches++;
            }
        }
        return mismatches;
    }

    private int countCharsAndGetMax(String s, int[] chars) {
        int max = 0; int charValue;
        for(int i = 0; i < s.length(); i++) {
            charValue = s.charAt(i);
            chars[charValue]++;
            if (chars[charValue] > max) {
                max = chars[charValue];
            }
        }
        return max;
    }
}
