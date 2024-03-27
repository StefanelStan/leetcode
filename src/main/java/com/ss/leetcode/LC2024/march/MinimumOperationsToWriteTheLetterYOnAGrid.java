package com.ss.leetcode.LC2024.march;

public class MinimumOperationsToWriteTheLetterYOnAGrid {
    // https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid
    /** Algorithm
        1. Count the number of 0,1,2 cells in the Y path. EG: [7,3,2] (7 0s, 3 1s and 2 2s)
            - The best selection is to change ALL the numbers into 0, because 0 has the majority count.
            - Changing the other Y cells into 0 would have a cost of 12 (all cells) - 7 = 5.
        2. Looking at the "other" cells (outside the Y path), those also need to be made of same number,    but distinct from Y path cells.
        3. #1 & #2 => traverse whole grid and keep track of yCellsCount[3] and otherCellsCount[3]
        4. By turn, make all Y cells to be 0,1,2. If Y is 0, then other cells can be 1 or 2. The best choice is min(makeOtherCells[(1), makeOtherCells(2)).
        5. For each number 0,1,2, make the Y cells of that number and the other (non Y path) cells the minCost between the other two numbers.
        6. Return the min cost.
     */
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] yCellsCount = new int[3];
        int[] otherCellsCount = new int[3];
        countCells(grid, yCellsCount, otherCellsCount);
        return countMinOperations(yCellsCount, otherCellsCount);
    }

    private void countCells(int[][] grid, int[] yCellsCount, int[] otherCellsCount) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isOnYPath(i, j, grid.length, grid[0].length)) {
                    yCellsCount[grid[i][j]]++;
                } else {
                    otherCellsCount[grid[i][j]]++;
                }
            }
        }
    }

    private boolean isOnYPath(int i, int j, int rows, int columns) {
        return (i == j && j <= columns / 2) // main diagonal
            || (i == (columns - j) - 1 && j >= columns / 2) // second diagonal
            || (j == columns / 2 && i >= rows / 2); // vertical down
    }

    private int countMinOperations(int[] yCellsCount, int[] otherCellsCount) {
        int totalY = yCellsCount[0] + yCellsCount[1] + yCellsCount[2];
        int totalOthers = otherCellsCount[0] + otherCellsCount[1] + otherCellsCount[2];
        int minOperations = Integer.MAX_VALUE;
        int yCandidate, otherCandidate;
        for (int i = 0; i < yCellsCount.length; i++) {
            yCandidate = totalY - yCellsCount[i];
            otherCandidate = Integer.MAX_VALUE;
            for (int j = 0; j < otherCellsCount.length; j++) {
                if (j != i) {
                    otherCandidate = Math.min(otherCandidate, totalOthers - otherCellsCount[j]);
                }
            }
            minOperations = Math.min(minOperations, yCandidate + otherCandidate);
        }
        return minOperations;
    }
}
