package com.ss.leetcode.LC2022.march;

public class BackspaceStringCompare {
    // https://leetcode.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sStb = getStringContent(s);
        StringBuilder tStb = getStringContent(t);
        if (sStb.length() != tStb.length()) {
            return false;
        }
        return sStb.toString().equals(tStb.toString());
    }

    private StringBuilder getStringContent(String s) {
        StringBuilder stb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stb.append(s.charAt(i));
            } else {
                stb.setLength(Math.max(0, stb.length() -1));
            }
        }
        return stb;
    }
}
