package com.ss.leetcode.LC2025.january;

import java.util.LinkedList;

public class CheckIfAParenthesesStringCanBeValid {
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Integer> unlocked = new LinkedList<>();
        LinkedList<Integer> lockedOpen = new LinkedList<>();
        char sChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            if (locked.charAt(i) == '1') {
                if (sChar == ')') {
                    if (!lockedOpen.isEmpty()) {
                        lockedOpen.removeLast();
                    } else if (!unlocked.isEmpty()) {
                        unlocked.removeLast();
                    } else {
                        return false;
                    }
                } else {
                    lockedOpen.addLast(i);
                }
            } else {
                unlocked.addLast(i);
            }
        }
        while (!lockedOpen.isEmpty() && !unlocked.isEmpty() && lockedOpen.peekLast() < unlocked.peekLast()) {
            lockedOpen.removeLast();
            unlocked.removeLast();
        }
        return lockedOpen.isEmpty();
    }
}
