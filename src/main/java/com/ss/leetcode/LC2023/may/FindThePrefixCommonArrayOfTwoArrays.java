package com.ss.leetcode.LC2023.may;

public class FindThePrefixCommonArrayOfTwoArrays {
    // https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
    /** Algorithm
        1. Map the positions of B into an array: eg: B = [3,1,2,4] => pos [0,1,2,0,3]
            EG: number 3 is found at position 0 pos[3] = 0
            number 4 is at position pos[4] = 3.
        2. For each i = 0, n
            - loop with j from i to 0. Look for position of A[j] inside B (use bPos[A[j]]).
            - If the pos is <= i, then the number depicted by A[J] appears both in A and B in a position <= i.
        3. For each inner loop, set the commonPRefix[i].
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] bPos = getPositionsOf(B);
        return findCommonPrefix(A, bPos);
    }

    private int[] getPositionsOf(int[] B) {
        int[] pos = new int[B.length+1];
        for (int i = 0; i < B.length; i++) {
            pos[B[i]] = i;
        }
        return pos;
    }

    private int[] findCommonPrefix(int[] A, int[] bPos) {
        int[] commonPrefix = new int[A.length];
        int current = 0;
        for (int i = 0; i < commonPrefix.length; i++) {
            current = 0;
            for (int j = i; j >= 0; j--) {
                if (bPos[A[j]] <= i) {
                    current++;
                }
            }
            commonPrefix[i] = current;
        }
        return commonPrefix;
    }
}
