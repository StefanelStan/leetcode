package com.ss.leetcode.january;

public class SplitTwoStringsToMakePalindrome {
    // https://leetcode.com/problems/split-two-strings-to-make-palindrome/
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }
        boolean canAHavePalindrome = checkIfStringCanHavePalindrome(a, b);
        boolean canBHavePalindrome = checkIfStringCanHavePalindrome(b, a);

        return canAHavePalindrome || canBHavePalindrome;
    }

    private boolean isPalindrome(String s) {
        final int length = s.length();
        if (length == 0 || length == 1) {
            return true;
        }
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfStringCanHavePalindrome(String a, String b) {
        boolean canUpperBranchBePalindrome = true;
        boolean canBottomBranchBePalindrome = true;
        boolean firstStringCut = false;
        final int end = b.length() - 1;
        for (int i = 0; i < a.length() / 2; i++) {
            if (!firstStringCut && a.charAt(i) != b.charAt(end - i)) {
                    firstStringCut = true;
            }
            if (firstStringCut) {
                if (canUpperBranchBePalindrome && a.charAt(i) != a.charAt(end - i)) {
                    canUpperBranchBePalindrome = false;
                }
                if (canBottomBranchBePalindrome && b.charAt(i) != b.charAt(end - i)) {
                    canBottomBranchBePalindrome = false;
                }
            }
        }
        return canUpperBranchBePalindrome || canBottomBranchBePalindrome;

    }
}
