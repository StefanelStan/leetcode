package com.ss.leetcode.LC2023.november;

import java.util.ArrayList;
import java.util.List;

public class LargestSubmatrixWithRearrangements {
    // https://leetcode.com/problems/largest-submatrix-with-rearrangements
    public int largestSubmatrix(int[][] matrix) {
        int largest = 0;
        for (int i = 0; i < matrix.length; i++) {
            largest = Math.max(largest, findLargestMatrixByRow(matrix, i, largest));
        }
        return largest;
    }

    private int findLargestMatrixByRow(int[][] matrix, int row, int largest) {
        List<Integer> onesRow = getOnesOnRow(matrix[row]);
        int largestOnRow = onesRow.size();
        int size = onesRow.size();
        for (int i = row + 1; i < matrix.length  && size > 0 && size * (matrix.length - row) > largest; i++) {
            for (int j = 0; j < size;) {
                if (matrix[i][onesRow.get(j)] == 0) {
                    onesRow.set(j, onesRow.get(size -1));
                    size--;
                } else {
                    j++;
                }
            }
            largestOnRow = Math.max(largestOnRow, size * (1 + i - row));
        }
        return largestOnRow;

    }

    private List<Integer> getOnesOnRow(int[] row) {
        List<Integer> ones = new ArrayList<>();
        for (int j = 0; j < row.length; j++) {
            if (row[j] == 1) {
                ones.add(j);
            }
        }
        return ones;
    }
}
