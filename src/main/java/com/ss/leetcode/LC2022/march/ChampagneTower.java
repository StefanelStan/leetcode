package com.ss.leetcode.LC2022.march;

public class ChampagneTower {
    // https://leetcode.com/problems/champagne-tower/
    // MORE PERFORMANT
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] current = {poured};
        double[] next = new double[current.length + 1];
        int row, col;
        double halfDiff;
        for (row = 0; row <= query_row; row++) {
            for (col = 0; col <= row; col++) {
                if (current[col] > 1) {
                    halfDiff = (current[col] - 1) /2;
                    next[col] += halfDiff;
                    next[col + 1] += halfDiff;
                }
            }
            if (row == query_row && col > query_glass) {
                break;
            }
            current = next;
            next = new double[current.length + 1];
        }
        return current[query_glass] > 1 ? 1 : current[query_glass];
    }


    public double champagneTower2(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][201];
        int rowGlass, left = 100, right = 100;
        tower[0][100] = poured;
        for (int i = 0; i < 100; i++) {
            rowGlass = 0;
            for (int j = left; j <= right; j += 2) {
                if (tower[i][j] > 1.0) {
                    tower[i+1][j-1] += (tower[i][j] -1) /2;
                    tower[i+1][j+1] += (tower[i][j] -1) /2;
                    tower[i][j] = 1;
                }
                if (i == query_row && rowGlass == query_glass) {
                    return tower[i][j];
                }
                rowGlass++;
            }
            left--;
            right++;
        }
        return 0.0;
    }
}
