package com.ss.leetcode.LC2023.june;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    // ttps://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends
    /** Algorithm
        1. If s length == 1, return 1 immediately
        2. Use 2 pointers (left / right) that will traverse from 0..n-1 and n-1..0
            Left pointer will traverse from left while s[left] == leftChar (first distinct char)
            Right will traverse from right while s[right] == rightChar.
        3. Inside a While left < right and leftChar == rightChar try to traverse with left and right index.
            Pay attention this outter while left < right. This comes into place where you have just 1 single
            char that is distinct in the middle : eg: abbcba : left and right will stop @ index 3.
        4. If left will pass right, then return 0 as all char can be paired and eliminated
            - else set your new leftChar/rightChar and repeat step #3.
     */
    public int minimumLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int left = 0, right = s.length() - 1;
        char leftChar = s.charAt(left), rightChar = s.charAt(right);
        while (left < right && leftChar == rightChar) {
            while (left <= right && s.charAt(left) == leftChar) {
                left++;
            }
            while(left <= right && s.charAt(right) == rightChar) {
                right--;
            }
            if (left > right) {
                return 0;
            } else {
                leftChar = s.charAt(left);
                rightChar = s.charAt(right);
            }
        }
        return (right - left) + 1;
    }
}
