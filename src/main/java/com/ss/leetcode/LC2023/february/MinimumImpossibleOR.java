package com.ss.leetcode.LC2023.february;

public class MinimumImpossibleOR {
    // NOT CORRECT
    public int minImpossibleOR(int[] nums) {
        int[][] matrix = new int[nums.length + 1][32];
        for (int i = 0; i < nums.length; i++) {
            addBitsToMatrix(matrix, nums[i], i);
        }
        traverseMatrixAndSetBits(matrix);

        StringBuilder stb = new StringBuilder();
        for(int v : matrix[matrix.length -1]) {
            stb.append(v);
        }
        return Integer.parseInt(stb.toString(), 2);
    }

    private void addBitsToMatrix(int[][] matrix, int num, int row) {
        char[] bits = Integer.toBinaryString(num).toCharArray();
        int bitIndex = bits.length -1;
        for (int j = matrix[row].length -1; bitIndex >= 0; j--, bitIndex--) {
            matrix[row][j] = (bits[bitIndex] - '0');
        }
    }


    private void traverseMatrixAndSetBits(int[][] matrix) {
        int zeroCount, oneCount;
        for (int j = matrix[0].length -1; j >= 0; j--) {
            zeroCount = 0;
            oneCount = 0;
            for (int i = 0; i < matrix.length -1; i++) {
                if (matrix[i][j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            if (zeroCount == 0 || oneCount == 0) {
                matrix[matrix.length-1][j] = 1;
                break;
            }
        }
    }
}
