package com.ss.leetcode.march;

public class FlippingAnImage {
    // https://leetcode.com/problems/flipping-an-image/
    public int[][] flipAndInvertImage(int[][] image) {
        int swappedTemp;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <= (image[i].length -1) / 2; j++) {
                swappedTemp = image[i][j] == 0 ? 1 : 0;
                image[i][j] = image[i][image[i].length -1 - j] == 0 ? 1 : 0;
                image[i][image[i].length - 1 - j] = swappedTemp;
            }
        }
        return image;
    }
}
