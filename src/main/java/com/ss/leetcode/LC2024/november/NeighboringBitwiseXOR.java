package com.ss.leetcode.LC2024.november;

public class NeighboringBitwiseXOR {
    // https://leetcode.com/problems/neighboring-bitwise-xor
    /** Algorithm
        1. Fail fast: if length is 1, the only element will have a xor of 0 with itself
        2. Else,
            - if last derived is 1, then the (original[0] and original[n-1]) can be pairs of (1,0) and (0,1)
            - if derived is 0, then the (original[0] and original[n-1]) can be pairs of (0,0) or (1,1) (identical)
        3. Traverse derived and build original from the first element, knowing the first elemement
        4. Return if the last generated value matches the expected original[n-1] from the selected pair.
     */
    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }
        return derived[derived.length - 1] == 1 ? canFormArray(derived, 0, 1, 1, 0) : canFormArray(derived, 0, 1, 0, 1);
    }

    private boolean canFormArray(int[] derived, int start1, int start2, int end1, int end2) {
        for (int i = 0; i < derived.length - 1; i++) {
            start1 = derived[i] == 0 ? start1 : 1 - start1;
            start2 = derived[i] == 0 ? start2 : 1 - start2;
        }
        return start1 == end1 || start2 == end2;
    }
}
