package com.ss.leetcode.LC2022.april;

import java.util.Arrays;

public class NextGreaterElementIII {
    // https://leetcode.com/problems/next-greater-element-iii/
    public int nextGreaterElement(int n) {
        String nString = String.valueOf(n);
        char[] nChar = nString.toCharArray();
        long nextGreater = Long.MAX_VALUE, candidate;
        for (int i = nChar.length -1; i > 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (nChar[i] > nChar[j]) {
                    candidate = getCandidate(nString.toCharArray(), j, i);
                    if (isValidCandidate(candidate, n)) {
                        nextGreater = Math.min(candidate, nextGreater);
                    }
                    break;
                }
            }
        }
        return nextGreater == Long.MAX_VALUE ? -1 : (int)nextGreater;
    }

    private long getCandidate(char[] chrs, int left, int right) {
        char temp = chrs[left];
        chrs[left] = chrs[right];
        chrs[right] = temp;
        Arrays.sort(chrs, left +1, chrs.length);
        return Long.parseLong(new String(chrs));
    }

    private boolean isValidCandidate(long candidate, long nLong) {
        return candidate <= Integer.MAX_VALUE && nLong < candidate;
    }
}
