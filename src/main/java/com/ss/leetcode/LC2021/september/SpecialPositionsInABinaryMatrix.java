package com.ss.leetcode.LC2021.september;

public class SpecialPositionsInABinaryMatrix {
    // https://leetcode.com/problems/special-positions-in-a-binary-matrix/
    /** Algorithm
        1. Go row by row and check if that is a good row: eg: sum is 1.
        2. While doing #1, if the sum reaches two, break and return false. That row can't be counted as good row.
        3. While doing #1, also keep track of lastPos in row that had a 1. You will use that lastPos to compute the colSum of mat[x][lastPos]
        4. If the colSum of column lastPos is 1, then that position is valid.
     */
    public int numSpecial(int[][] mat) {
        int special = 0;
        for (int[] line : mat) {
            special += (isGoodLine(line, mat) ? 1 : 0);
        }
        return special;
    }

    private boolean isGoodLine(int[] row, int[][] mat) {
        int lastPos = 0, rowSum = 0;
        for (int j = 0; j < row.length && rowSum < 2; j++) {
            if (row[j] == 1) {
                lastPos = j;
                rowSum++;
            }
        }
        return rowSum == 1 && colSum(lastPos, mat) == 1;
    }

    private int colSum(int col, int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length && sum < 2; i++) {
            sum += mat[i][col];
        }
        return sum;
    }


    public int numSpecial2(int[][] mat) {
        int special = 0;
        for (int[] line : mat) {
            if (isGoodLine2(line, mat)) {
                special++;
            }
        }
        return special;
    }

    private boolean isGoodLine2(int[] line, int[][] mat) {
        int pos = -1;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 1) {
                if (pos != -1) {
                    return false;
                }
                pos = i;
            }
        }
        if (pos == -1) {
            return false;
        }
        boolean colFound = false;
        for (int[] ints : mat) {
            if (ints[pos] == 1) {
                if (colFound) {
                    return false;
                }
                colFound = true;
            }
        }
        return true;
    }
}
