package com.ss.leetcode.april;

import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckNumbers = new LinkedList<>();
        int[] maxColumns = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            maxColumns[j] = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > maxColumns[j]) {
                    maxColumns[j] = matrix[i][j];
                }
            }
        }
        int minPerRow;
        int colNumber;
        for (int[] row :  matrix) {
            minPerRow = row[0];
            colNumber = 0;
            for (int j = 1; j < row.length; j++) {
                if (row[j] < minPerRow) {
                    minPerRow = row[j];
                    colNumber = j;
                }
            }
            if (maxColumns[colNumber] == minPerRow) {
                luckNumbers.add(minPerRow);
            }
        }
        return luckNumbers;
    }
}
