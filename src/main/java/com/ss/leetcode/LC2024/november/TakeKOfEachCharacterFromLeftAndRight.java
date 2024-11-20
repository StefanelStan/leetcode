package com.ss.leetcode.LC2024.november;

public class TakeKOfEachCharacterFromLeftAndRight {
    // https://leetcode.com/problems/take-k-of-each-character-from-left-and-right
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int minMinutes = s.length();
        int[] leftWindow = new int[3];
        int[] rightWindow = getRightWindow(s);
        if (!isValid(leftWindow, rightWindow, k)) {
            return -1;
        }
        for (int left = -1, right = 0; left < s.length(); left++) {
            if (left >= 0) {
                leftWindow[s.charAt(left) - 'a']++;
            }
            while (right < s.length() && isValid(leftWindow, rightWindow, k)) {
                minMinutes = Math.min(minMinutes, getSum(leftWindow, rightWindow));
                rightWindow[s.charAt(right) - 'a']--;
                if (isValid(leftWindow, rightWindow, k)) {
                    minMinutes = Math.min(minMinutes, getSum(leftWindow, rightWindow));
                }
                right++;
            }
            right = Math.max(left + 1, right);
        }
        return minMinutes;
    }

    private int[] getRightWindow(String s) {
        int[] right = new int[3];
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a']++;
        }
        return right;
    }

    private boolean isValid(int[] left, int[] right, int minCount) {
        return left[0] + right[0] >= minCount && left[1] + right[1] >= minCount && left[2] + right[2] >= minCount;
    }

    private int getSum(int[] left, int[] right) {
        return left[0] + left[1] + left[2] + right[0] + right[1] + right[2];
    }
}
