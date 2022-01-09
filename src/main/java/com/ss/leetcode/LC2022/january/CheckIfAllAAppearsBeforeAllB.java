package com.ss.leetcode.LC2022.january;

public class CheckIfAllAAppearsBeforeAllB {
    // https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
    public boolean checkString(String s) {
        boolean isAFound = false;
        for(int i = s.length() -1; i >=0; i--) {
            if (s.charAt(i) == 'a') {
                isAFound = true;
            } else if (isAFound) {
                return false;
            }
        }
        return true;
    }
}
