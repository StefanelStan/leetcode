package com.ss.leetcode.LC2021.february;

import java.util.PrimitiveIterator;

public class MinimumChangesToMakeAlternatingBinaryString {
    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
    public int minOperations(String s) {
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
