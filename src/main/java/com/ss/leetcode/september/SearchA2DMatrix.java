package com.ss.leetcode.september;

public class SearchA2DMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) {
            return searchInRow(matrix, 0, target);
        }
        int rowIndex = searchRowIndex(matrix, target);
        if (rowIndex == -1) {
            return false;
        }
        return searchInRow(matrix, rowIndex, target);
    }

    private int searchRowIndex(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length -1;
        while(low <= high) {
            int pivot = low + (high - low) / 2;
            if (matrix[pivot][0] > target) {
                high = pivot -1;
            } else if (matrix[pivot][matrix[pivot].length -1] < target) {
                low = pivot +1;
            } else {
                return pivot;
            }
        }
        return -1;
    }

    private boolean searchInRow(int[][] matrix, int rowIndex, int target) {
        int low = 0;
        int high = matrix[rowIndex].length -1;
        while(low <= high) {
            int pivot = low + (high - low) / 2;
            if (matrix[rowIndex][pivot] < target) {
                low = pivot + 1;
            } else if (matrix[rowIndex][pivot] > target) {
                high = pivot -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
