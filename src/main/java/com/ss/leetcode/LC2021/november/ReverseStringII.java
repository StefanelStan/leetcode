package com.ss.leetcode.LC2021.november;

public class ReverseStringII {
    // https://leetcode.com/problems/reverse-string-ii/
    public String reverseStr(String s, int k) {
        char[] reversed = new char[s.length()];
        int i = 0;
        for (; i + 2 * k <= s.length(); i += 2 * k) {
            copyReversed(i, i + k - 1, s, reversed);
            copyInOrder(i + k, i + 2 * k - 1, s, reversed);
        }
        if (s.length() - i < k) {
            copyReversed(i, s.length() - 1, s, reversed);
        } else if (s.length() - i < 2 * k) {
            copyReversed(i, i + k - 1, s, reversed);
            copyInOrder(i + k, s.length() - 1, s, reversed);
        }
        return new String(reversed);
    }

    private void copyReversed(int sStart, int sEnd, String s, char[] reversed) {
        while (sStart <= sEnd) {
            reversed[sStart] = s.charAt(sEnd);
            reversed[sEnd] = s.charAt(sStart);
            sStart++;
            sEnd--;
        }
    }

    private void copyInOrder(int sStart, int sEnd, String s, char[] reversed) {
        while (sStart <= sEnd) {
            reversed[sStart] = s.charAt(sStart++);
        }
    }
}
