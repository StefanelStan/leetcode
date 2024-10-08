package com.ss.leetcode.LC2024.october;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    // https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced
    /** Algorithm
        1. Traverse string and track the counter of opened paranthesis. (increment for [ and decrement for ])
        2. If the current counter is negative, then the minSwaps max (minSwaps, Math.abs(opened)).
        3. Return (minSwaps + 1) / 2.
     */
    public int minSwaps(String s) {
        int minSwaps = 0, opened = 0;
        for (int i = 0; i < s.length(); i++) {
            opened += s.charAt(i) == '[' ? 1 : -1;
            if (opened < 0) {
                minSwaps = Math.max(minSwaps, -opened);
            }
        }
        minSwaps += minSwaps % 2 == 1 ? 1 : 0;
        return minSwaps / 2;
    }

    public int minSwaps2(String s) {
        int openOnLeft = 0, closedOnRight = 0;
        char charOnLeft, charOnRight;
        int swaps = 0;
        for (int left = 0, right = s.length() - 1; left < right;) {
            while (left < right && openOnLeft >= 0) {
                charOnLeft = s.charAt(left);
                if (charOnLeft == '[') {
                    openOnLeft++;
                    left++;
                } else if (openOnLeft > 0) {
                    openOnLeft--;
                    left++;
                } else {
                    openOnLeft = -1;
                }
            }
            while (left < right && closedOnRight >= 0) {
                charOnRight = s.charAt(right);
                if (charOnRight == ']') {
                    closedOnRight++;
                    right--;
                } else if (closedOnRight > 0) {
                    closedOnRight--;
                    right--;
                } else {
                    closedOnRight = -1;
                }
            }
            if (left < right && openOnLeft == -1 && closedOnRight == -1) {
                openOnLeft = 1;
                closedOnRight = 1;
                left++;
                right--;
                swaps++;
            }
        }
        return swaps;
    }
}
