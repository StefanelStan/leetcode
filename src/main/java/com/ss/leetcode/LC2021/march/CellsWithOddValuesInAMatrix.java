package com.ss.leetcode.LC2021.march;

public class CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] indice : indices) {
            increaseValue(matrix, indice);
        }

        return countOddCells(matrix);
    }

    private void increaseValue(int[][] matrix, int[] indice) {
        for (int col = 0; col < matrix[0].length; col++){
            matrix[indice[0]][col] += 1;
        }

        for (int row = 0; row < matrix.length; row++){
            matrix[row][indice[1]] += 1;
        }
    }

    private int countOddCells(int[][] matrix) {
        int odd = 0;
        for(int[] row: matrix) {
            for (int col : row){
                if (col % 2 != 0) {
                    odd++;
                }
            }
        }
        return odd;
    }
}
