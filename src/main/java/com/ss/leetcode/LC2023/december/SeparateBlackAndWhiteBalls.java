package com.ss.leetcode.LC2023.december;

public class SeparateBlackAndWhiteBalls {
    // https://leetcode.com/problems/separate-black-and-white-balls
    /** Algorithm
        1. Use two pointers: left starts at 0, right at n-1;
        2. Move left to the first 1; move right to the first 0;
        3. Once found and left < right, you will need (right - left) moves to swap them
        4. Add the diff to total and move left / right to next (left++, right--)
        5. Return total;
     */
    public long minimumSteps(String s) {
        int left = 0, right = s.length() - 1;
        long total = 0;
        while (left < right) {
            while (left < right && s.charAt(left) == '0') {
                left++;
            }
            while (left < right && s.charAt(right) == '1') {
                right--;
            }
            if (left < right) {
                total += (right - left);
                left++;
                right--;
            }
        }
        return total;
    }
}
