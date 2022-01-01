package com.ss.leetcode.LC2022.january;

public class LongPressedName {
    // https://leetcode.com/problems/long-pressed-name/
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        } else if (name.length() == typed.length()) {
            return name.equals(typed);
        } else {
            return checkIfLongPressed(name, typed);
        }
    }

    private boolean checkIfLongPressed(String name, String typed) {
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int j = 0;
        for (int i =1; i < name.length(); i++) {
            j = getFirstPosOf(typed, name.charAt(i), name.charAt(i-1), j+1);
            if (j == -1) {
                return false;
            }
        }
        // case when i ends but j still have some letters;
        if (j < typed.length()) {
            for (; j < typed.length(); j++) {
                if (typed.charAt(j) != name.charAt(name.length() -1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getFirstPosOf(String typed, char searched, char prev, int fromIndex) {
        for (int i = fromIndex; i < typed.length(); i++) {
            if (typed.charAt(i) == searched) {
                return i;
            } else if (typed.charAt(i) != prev) {
                return -1;
            }
        }
        return -1;
    }
}
