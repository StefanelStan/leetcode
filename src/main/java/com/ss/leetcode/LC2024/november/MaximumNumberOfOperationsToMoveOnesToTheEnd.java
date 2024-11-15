package com.ss.leetcode.LC2024.november;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    // https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end
    /** Algorithm
        1. The idea is we travel from left to right and count 1s. When we encounter a 0, we know that all 1s need to be shifted to the right.
        2. Traverse s with i from 0 to n-1, keeping track of number of 1s, maxOperations and a boolean haveBeenAdded flag (false).
        3. If current char is 1, increment the count of 1s; also, set the flag to false.
        4. If current char is 0 AND the flag is false, the ALL the 1s need to be shifted to the right. Add 1s to maxOperations and set flag to false.
     */
    public int maxOperations(String s) {
        int maxOperations = 0, ones = 0;
        boolean haveBeenAdded = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
                haveBeenAdded = false;
            } else if (!haveBeenAdded) {
                haveBeenAdded = true;
                maxOperations += ones;
            }
        }
        return maxOperations;
    }
}
