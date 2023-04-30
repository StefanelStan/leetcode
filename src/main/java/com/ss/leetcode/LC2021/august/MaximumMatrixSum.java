package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumMatrixSum {
    // https://leetcode.com/problems/maximum-matrix-sum
    /** Algorithm
        1. Looking at the numbers in the matrix, just ignore any number and look at the signs: + and -.
        2. From this graphical view, ask: can you bring the minuses together to pair them?
        3. Yes, flipping 2 cells will move/shift the minuses together.
        4. Knowing this, all you need to know if how many negatives you have:
            - if you have an even number of negatives, then all can be paired and flipped, becoming positives.
            - if you have an ODD number of negatives, then one negative can't be paired.
        5. Traverse the matrix and calculate the sum of absolute values. Also count the negatives and
            keep track of the minimum absolute value.
            - If you have a 0, then any negative can be flipped to become a positive: [-5, 0] -> [5,0],
            so you know that ALL negatives can become positive
        6. If you have an ODD number of negatives, a number will be left out to be negative.
            You want to pick the minimum absolute number for that in order to maximize your sum.
     */
    public long maxMatrixSum(int[][] matrix) {
        long absSum = 0L;
        int negativeCount = 0;
        int minAbs = 100_001;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    negativeCount++;
                }
                absSum += Math.abs(num);
                minAbs = Math.min(minAbs, Math.abs(num));
            }
        }
        // if you have a 0 or even negatives, then all negatives can be flipped to be positive
        // ELSE, just pick the minimum absolute number and keep that as negative.
        return minAbs == 0 || negativeCount % 2 == 0 ? absSum : absSum - 2 * minAbs;
    }

    // LOL Solution :)
    public long maxMatrixSum2(int[][] matrix) {
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
