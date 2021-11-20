package com.ss.leetcode.november;

public class IsSubsequence {
    // https://leetcode.com/problems/is-subsequence/
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.length() == 0 || s.equals(t);
        }
        int sIndex = 0, tIndex =0;
        while(tIndex < t.length() && sIndex < s.length()) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}
