package com.ss.leetcode.LC2025.january;

public class ModifyTheMatrix {
    // https://leetcode.com/problems/modify-the-matrix
    /** Algorithm
        1. For each column:
        - traverse it and get the max
        - traverse each row again and if the element is -1, set the answer[i][j] to max, else set it to matrix[i][j];
     */
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] answer = new int[matrix.length][matrix[0].length];
        for (int j = 0, max = -1; j < matrix[0].length; j++, max = -1) {
            for (int[] row : matrix) {
                max = Math.max(max, row[j]);
            }
            for (int i = 0; i < answer.length; i++) {
                answer[i][j] = matrix[i][j] == -1 ? max : matrix[i][j];
            }
        }
        return answer;
    }
}
