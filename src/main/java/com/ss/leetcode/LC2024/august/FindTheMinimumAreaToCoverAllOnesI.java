package com.ss.leetcode.LC2024.august;

public class FindTheMinimumAreaToCoverAllOnesI {
    // https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i
    /** Algorithm
        1. The rectangle area is width * height.
        2. The height is given by 1 + last row which has 1 - first row that has 1.
        3. The width is given by 1 + right most column with 1 - left most column that has 1.
     */
    public int minimumArea(int[][] grid) {
        int topX = Integer.MAX_VALUE, bottomX = 0, leftY = Integer.MAX_VALUE, rightY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    topX = Math.min(topX, i);
                    bottomX = i;
                    leftY = Math.min(leftY, j);
                    rightY = Math.max(rightY, j);
                }
            }
        }
        return  (1 + bottomX - topX) *  (1 + rightY - leftY);
    }
}
