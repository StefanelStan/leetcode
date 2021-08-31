package com.ss.leetcode.august;

public class FloodFill {
    // https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fillNearbyCells(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fillNearbyCells(int[][] image,  int i, int j, int oldColor, int newColor) {
        if (image[i][j] == oldColor && image[i][j] != newColor) {
            image[i][j] = newColor;
            if (i > 0) {
                fillNearbyCells(image, i - 1, j, oldColor, newColor);
            }
            if (j > 0) {
                fillNearbyCells(image, i, j - 1, oldColor, newColor);
            }
            if (i < image.length - 1) {
                fillNearbyCells(image, i + 1, j, oldColor, newColor);
            }
            if (j < image[i].length -1 ) {
                fillNearbyCells(image, i, j + 1, oldColor, newColor);
            }
        }
    }
}
