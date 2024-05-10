package com.ss.leetcode.LC2024.may;

public class MatrixSimilarityAfterCyclicShifts {
    // https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts
    /** Algorithm
        1. For each row[] of mat[][], you need to determine if row[i] == row[target].
        2. The trick for even and odd is that they are similar: they both need same condition
            EG: i = 5, k = 3.
            - right shift: row[5] == row[8]
            - left shift: row[5] == row[2] => however, row[8] must be == row[5(8-3)].
        3. Traverse each row and calculate the equality between each column and shift.
     */
    public boolean areSimilar(int[][] mat, int k) {
        boolean similar = true;
        int target;
        for (int i = 0; i < mat.length && similar; i++) {
            for (int j = 0; j < mat[0].length && similar; j++) {
                target = (j + k) % mat[i].length;
                similar = mat[i][j] == mat[i][target];
            }
        }
        return similar;
    }
}
