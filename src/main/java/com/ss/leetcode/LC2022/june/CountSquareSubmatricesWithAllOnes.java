package com.ss.leetcode.LC2022.june;

public class CountSquareSubmatricesWithAllOnes {
    // https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    // PREFIX SOLUTION
    public int countSquares(int[][] matrix) {
        int[][] prefixSum = getPrefixSum(matrix);
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count += 1 + countSquareMatrix(i, j, prefixSum);
                }
            }
        }
        return count;
    }

    private int countSquareMatrix(int i, int j, int[][] prefixSum) {
        int count = 0;
        for (int step = 1; i + step < prefixSum.length && j + step < prefixSum[0].length; step++) {
            if ((step + 1) * (step + 1) == prefixSum[i + step][j + step] - getExclusiveSum(i, j, step, prefixSum)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int getExclusiveSum(int i, int j, int dist, int[][] prefixSum) {
        int leftSum = j == 0 ? 0 : prefixSum[i + dist][j-1];
        int topSum = i == 0 ? 0 : prefixSum[i-1][j + dist];
        int crossSum = i == 0 || j == 0 ? 0 : prefixSum[i-1][j-1];
        return leftSum + topSum - crossSum;
    }

    private int[][] getPrefixSum(int[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        prefixSum[0][0] = matrix[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            prefixSum[0][j] = prefixSum[0][j-1] + matrix[0][j];
        }
        int rowSum;
        for (int i = 1; i < matrix.length; i++) {
            rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                prefixSum[i][j] = rowSum + prefixSum[i-1][j];
            }
        }
        return prefixSum;
    }

    public int countSquares2(int[][] matrix) {
        int squares = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                squares += countExpandingSquares(i, j, matrix);
            }
        }
        return squares;
    }

    private int countExpandingSquares(int i, int j, int[][] matrix) {
        if (matrix[i][j] == 1) {
            return 1 + expandSquare(i, j, 1, matrix);
        } else {
            return 0;
        }
    }

    private int expandSquare(int i, int j, int distance, int[][] matrix) {
        if (validLine(i, j, distance, matrix) && validColumn(i, j, distance, matrix)) {
            return expandSquare (i, j, distance +1, matrix);
        } else {
            return distance -1;
        }
    }

    private boolean validLine(int i, int j, int distance, int[][] matrix) {
        if (j + distance >= matrix[0].length || i + distance >= matrix.length) {
            return false;
        }
        for (int line = i + distance, col = j; col <= j + distance; col++) {
            if (matrix[line][col] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(int i, int j, int distance, int[][] matrix) {
        if (i + distance >= matrix.length || j + distance >= matrix[0].length) {
            return false;
        }
        for (int row = i, col = j + distance; row <= i + distance; row++) {
            if (matrix[row][col] == 0) {
                return false;
            }
        }
        return true;
    }
}
