package com.ss.leetcode.march;

public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int totalBalancedStrings = 0;
        int balance = 0;
        for (int i =0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                totalBalancedStrings++;
            }
        }

        return totalBalancedStrings;
    }
}
