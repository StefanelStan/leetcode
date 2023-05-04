package com.ss.leetcode.LC2023.may;

public class FindTheWidthOfColumnsOfAGrid {
    // https://leetcode.com/problems/find-the-width-of-columns-of-a-grid
    /** Algorithm
        1. Declare an int[] of size n (n columns)
        2. For each column j 0..n, determine and set the width:
            - determine the min and max of that column
            - return the maxLength of (min, max)
        3. Return the answer;
     */
    public int[] findColumnWidth(int[][] grid) {
        int[] maxColLength = new int[grid[0].length];
        for (int j = 0; j < maxColLength.length; j++) {
            maxColLength[j] = getMaxColLength(grid, j);
        }
        return maxColLength;
    }

    private int getMaxColLength(int[][] grid, int col) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] row : grid) {
            min = Math.min(min, row[col]);
            max = Math.max(max, row[col]);
        }
        return Math.max(getIntLength(min), getIntLength(max));
    }

    private int getIntLength(int num) {
        int len = num <= 0 ? 1 : 0;
        while (num != 0) {
            num = num / 10;
            len++;
        }
        return len;
    }
}
