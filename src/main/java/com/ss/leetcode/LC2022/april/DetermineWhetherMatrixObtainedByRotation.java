package com.ss.leetcode.LC2022.april;

public class DetermineWhetherMatrixObtainedByRotation {
    // https://leetcode.com/submissions/detail/685334582/
    public boolean findRotation(int[][] mat, int[][] target) {
        int l = mat.length -1;
        return checkByRow(mat, target, 0, 0, 1) || checkByRow(mat, target, l, l, -1)
            || checkByCol(mat, target, 0, l, 1, -1) || checkByCol(mat, target, l, 0, -1, 1);
    }

    private boolean checkByRow(int[][] mat, int[][] target, int startR, int startC, int direction) {
        for (int mI = 0, tI = startR; mI < mat.length; mI++, tI += direction) {
            for(int mJ = 0, tJ = startC; mJ < mat.length; mJ++, tJ += direction) {
                if (mat[mI][mJ] != target[tI][tJ]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkByCol(int[][] mat, int[][] target, int startR, int startC, int rowDir, int colDir) {
        for(int mJ = 0, tJ = startC; mJ < mat.length; mJ++, tJ += colDir) {
            for(int mI = 0, tI = startR; mI < mat.length; mI++, tI += rowDir) {
                if(mat[mJ][mI] != target[tI][tJ]) {
                    return false;
                }
            }
        }
        return true;
    }
}
