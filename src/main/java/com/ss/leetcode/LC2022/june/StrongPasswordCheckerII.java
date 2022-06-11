package com.ss.leetcode.LC2022.june;

import java.util.Set;

public class StrongPasswordCheckerII {
    // https://leetcode.com/contest/biweekly-contest-80/problems/strong-password-checker-ii/
    private static final Set<Character> specialChars = Set.of('!', '@','#','$', '%','^','&','*','(',')','-','+');
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        char[] chrs = password.toCharArray();
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        boolean isDifferent = true;
        for (int i = 0; i < chrs.length; i++){
            if (Character.isUpperCase(chrs[i])) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(chrs[i])) {
                hasLowerCase = true;
            }
            if (Character.isDigit(chrs[i])) {
                hasDigit = true;
            }
            if (specialChars.contains(chrs[i])) {
                hasSpecialCharacter = true;
            }
            if (i < chrs.length -1 && chrs[i] == chrs[i+1]) {
                isDifferent = false;
            }
        }
        return hasLowerCase && hasUpperCase && hasDigit && hasSpecialCharacter && isDifferent;
    }
}
