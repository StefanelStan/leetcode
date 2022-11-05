package com.ss.leetcode.LC2022.november;

public class ImageSmoother {
    // https://leetcode.com/problems/image-smoother/
    /** Algorithm
         1. declare an answer[][] matrix that will store the smoothed image
         2. For each cell in img, calculate the sum and count the 3 elements from row-1, row and row+1 and add in in answer[][]
         3. Return and answer[]][]
     */
    public int[][] imageSmoother(int[][] img) {
        int[][] smoothImage = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                smoothImage[i][j] = applyFilter(i, j, img);
            }
        }
        return smoothImage;
    }

    private int applyFilter(int i, int j, int[][] img) {
        int[] count = {0};
        int sum = 0;
        for(int row = i-1; row <= i+1; row++) {
            sum += getRowSum(row, j, img, count);
        }
        return sum / count[0];
    }

    private int getRowSum(int row, int col, int[][] grid, int[] count) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }
        int sum = 0;
        for (int j = Math.max(0, col -1); j < Math.min(col + 2, grid[row].length); j++) {
            sum += grid[row][j];
            count[0]++;
        }
        return sum;
    }
}
