package com.ss.leetcode.LC2021.february;

import java.util.PrimitiveIterator;

public class MinimumChangesToMakeAlternatingBinaryString {
    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
    /** Algorithm
        1. If you wish to make string 01.., then you have a problem with 0s sitting at odd positions and 1s at even positions
        2. If you target string 10.., then you have a problem with 0s sitting at even indices and 1s at odd indices.
        3. Traverse s and count these problems, based if parity of current position
        4. Return min(zeroAtOddPos + oneAtEvenPos, zeroAtEvenPos + onesAtOddPos)
     */
    public int minOperations(String s) {
        int zeroAtOddPos = 0, zeroAtEvenPos = 0;
        int oneAtOddPos = 0, oneAtEvenPos = 0;
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - '0';
            if (i % 2 == 0) {
                oneAtEvenPos += codePoint;
                zeroAtEvenPos += codePoint == 0 ? 1 : 0;
            } else {
                oneAtOddPos += codePoint;
                zeroAtOddPos += codePoint == 0 ? 1 : 0;
            }
        }
        return Math.min(zeroAtEvenPos + oneAtOddPos, zeroAtOddPos + oneAtEvenPos);
    }

    public int minOperations2(String s) {
        int zero = '0';
        PrimitiveIterator.OfInt is = s.chars().iterator();
        int startZeroOperations = 0;
        int startOneOperations = 0;
        boolean onEvenPosition = true;
        int currentValue = 0;
        while(is.hasNext()) {
            currentValue = is.next();
            if(onEvenPosition) {
                // check for startWithZero
                if(currentValue != zero) {
                    startZeroOperations++;
                } else {
                    startOneOperations++;
                }
            } else {
                if(currentValue != zero) {
                    startOneOperations++;
                } else {
                    startZeroOperations++;
                }
            }
            onEvenPosition = !onEvenPosition;
        }
        return Math.min(startZeroOperations, startOneOperations);
    }
}
