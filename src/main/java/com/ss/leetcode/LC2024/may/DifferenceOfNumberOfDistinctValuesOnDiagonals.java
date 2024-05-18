package com.ss.leetcode.LC2024.may;

public class DifferenceOfNumberOfDistinctValuesOnDiagonals {
    // https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals
    /** Algorithm
        1. Using a prefix unique data structure, we can compute one diagonal at a time: [[0,0], [1,1],[2,2]], then [[0,1],[1,2],[2,3],[3,4]] etc
        2. Use a class that wraps an int[51] count to keep track of how many uniques you have so far.
            - each time you add a number, if prev count[num] == 0, then you have a new unique number
         - when you remove a number, if count[num] == 0, then you lose one unique number
        3. Compute the count for each diagonal that starts from i =0 and j = [0,m-1] and from diagonals that start from i = [1,n-1] and j = 0;
        4. At east step, set the result of abs(upper.unique - bottom.unique)
     */
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] distinct = new int[grid.length][grid[0].length];
        for (int j = grid[0].length - 1; j>=0; j--) {
            populateDistinctGrid(grid, 0, j, distinct);
        }
        for (int i = 1; i < grid.length; i++) {
            populateDistinctGrid(grid, i, 0, distinct);
        }
        return distinct;
    }

    public void populateDistinctGrid(int[][] grid, int row, int col, int[][] distinct) {
        DistinctValues upperValues = new DistinctValues();
        DistinctValues bottomValues = new DistinctValues();
        // count the uniques of whole diagonal, except the first number
        for (int i = row + 1, j = col + 1; i < grid.length && j < grid[0].length; i++, j++) {
            bottomValues.add(grid[i][j]);
        }
        distinct[row][col] = bottomValues.unique;
        // prefix unique: remove current number from bottom and add prev to upper diagonal
        for (int i = row + 1, j = col + 1; i < grid.length && j < grid[0].length; i++, j++) {
            bottomValues.remove(grid[i][j]);
            upperValues.add(grid[i-1][j-1]);
            distinct[i][j] = Math.abs(upperValues.unique - bottomValues.unique);
        }
    }

    private static class DistinctValues {
        int[] count;
        int unique;

        public DistinctValues () {
            count = new int[51];
        }

        public void add(int number) {
            if (++count[number] == 1) {
                unique++;
            }
        }

        public void remove(int number) {
            if (--count[number] == 0) {
                unique--;
            }
        }
    }
}
