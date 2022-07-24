package com.ss.leetcode.LC2021.january;

import java.util.Arrays;

public class SearchA2DMatrixII {
    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length -1] < target) {
            return false;
        }
        int width = matrix[0].length -1;
        for (int i = 0; i < matrix.length && target >= matrix[i][0]; i++) {
            if (matrix[i][width] >= target && binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (numbers[pivot] == target) {
                return true;
            } else if (target > numbers[pivot]) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        while(i < matrix.length && matrix[i][0] <= target) {
            if(Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
            i++;
        }
        return false;
    }

}
