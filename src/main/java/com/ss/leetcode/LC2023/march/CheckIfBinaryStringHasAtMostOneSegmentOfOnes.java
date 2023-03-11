package com.ss.leetcode.LC2023.march;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    // https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
    /** Algorithm
        1. As the string starts with 1, we always know there is a 1 segment present, but this has to be followed only by 0 or only by 1.
        2. Use a boolean flag zeroEncountered to flag is zero has been encountered
        3. If your current digit is 1 and zeroEncountered return false, as this is a 2nd segment.
     */
    public boolean checkOnesSegment(String s) {
        boolean encounteredZero = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                encounteredZero = true;
            } else if (encounteredZero) {
                return false;
            }
        }
        return true;
    }
}
