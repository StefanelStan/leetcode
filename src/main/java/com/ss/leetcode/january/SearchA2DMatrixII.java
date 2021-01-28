package com.ss.leetcode.january;

import java.util.Arrays;

public class SearchA2DMatrixII {
    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix(int[][] matrix, int target) {
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
