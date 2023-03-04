package com.ss.leetcode.LC2023.march;

public class CountTotalNumberOfColoredCells {
    // https://leetcode.com/problems/count-total-number-of-colored-cells/
    /** Algorithm
        1. We can observe that starting from n = 2, each expansion leads to 4 more cells that the number of edge cells.
            IE: n == 3 -> there are 8 edge cells. These 8 ege cells will color 12 more cells.
            The 12 cells will color 16 more and so on. (edge cells + 4)
        2. Loop from i = 4 to n, starting from edgeCells = 8. With each step, the edge cells will grow by 4 and totalNumber by edge cells count;
     */
    public long coloredCells(int n) {
        switch (n) {
            case 1: return 1;
            case 2: return 5;
            case 3 : return 13;
            default: return countCells(n);
        }
    }

    private long countCells(int n) {
        long totalCells = 13;
        long outerCells = 8;
        for (int i = 4; i <= n; i++) {
            outerCells += 4;
            totalCells += outerCells;
        }
        return totalCells;
    }
}
