package com.ss.leetcode.LC2022.march;

public class ChampagneTower {
    // https://leetcode.com/problems/champagne-tower/
    public double champagneTower(int poured, int query_row, int query_glass) {
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
