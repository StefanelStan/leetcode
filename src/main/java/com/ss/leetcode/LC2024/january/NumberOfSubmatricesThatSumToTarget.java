package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
    // Needs more attention
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += determineMatrixSum(i, matrix, target);
        }
        return total;
    }

    private int determineMatrixSum(int row, int[][] matrix, int target) {
        int total = 0, rowSum = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        int[] upperSum = new int[matrix[0].length];
        for (int i = row; i < matrix.length; i++) {
            sumCount.clear();
            rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                upperSum[j] += matrix[i][j];
                rowSum += upperSum[j];
                if (rowSum == target || matrix[i][j] == target) {
                    total++;
                }
                total += sumCount.getOrDefault(rowSum - target, 0);
                sumCount.merge(rowSum, 1, Integer::sum);
            }
        }
        return total;
    }
}
