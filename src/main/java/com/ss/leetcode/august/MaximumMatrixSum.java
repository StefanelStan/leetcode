package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long maxMatrixSum = 0;
        int minPositiveInt = Integer.MAX_VALUE;
        List<Integer> negatives = new ArrayList<>();
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell <= 0) {
                    negatives.add(cell);
                } else {
                    maxMatrixSum += cell;
                    minPositiveInt = Math.min(minPositiveInt, cell);
                }
            }
        }
        negatives.sort(Comparator.reverseOrder());
        int start = negatives.size() % 2 == 0 ? 0 : 1;
        for (int i = start; i < negatives.size(); i++) {
            maxMatrixSum += Math.abs(negatives.get(i));
        }

        maxMatrixSum = start == 0 ? maxMatrixSum : maxMatrixSum + (negatives.get(0));
        if (!negatives.isEmpty() && negatives.size() % 2 == 1) {
            if (Math.abs(negatives.get(0)) > minPositiveInt) {
                maxMatrixSum += Math.abs(negatives.get(0) * 2) - (minPositiveInt * 2L);
            }
        }

        return maxMatrixSum;
    }
}
