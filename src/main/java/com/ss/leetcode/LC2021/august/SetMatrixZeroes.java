package com.ss.leetcode.LC2021.august;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    // https://leetcode.com/problems/set-matrix-zeroes/
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int row : rows) {
            Arrays.fill(matrix[row], 0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int column : columns) {
                matrix[i][column] = 0;
            }
        }
    }
}
