package com.ss.leetcode.LC2023.july;

public class KnightProbabilityInChessboard {
    // https://leetcode.com/problems/knight-probability-in-chessboard
    /** Algorithm
        1. The whole idea is to jump from current position to any of the 8 ones.
        If you jump outside the board, then stop on your current thread jump.
        2. If you haven't finished ALL your jumps (k > 0), then continue jumping from current position onto the next 8 ones,
            lowering your remaining jumps.
        3. Thus, use a DFS method that will accept your current position and remaining number of jumps.
            This method will try to jump further.
        4. When your k reaches 0, then you return 1 for current jump.
            The helper method will collect ALL these returns and cache them into an array of move caches
        5. Use an int[][][] moves to count all possible moves for a given k
            Each cell should map each indidivual K remaining jumps:
            EG: 3x3, if you are on cell 0,0 and k = 1 then you can jump onto 2 valid positions.
            so [0][0][1] = 2;
            But if your K == 2, then from each two positions you can jump back.
            So for k = 2  [0][0][2] = 4.
        6. Jump and memoize how many jumps you can do when passing on a cell with k.k-1 remaining jumps.
        7. memo[row][col][k] will contain the number of jumps when you reach k = 0.
        8. This number must be divided by 8 ^ k.
     */
    private static final int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        } else if (n <= 2) {
            return 0;
        }
        double[][][] stepBoard = new double[n][n][k+1];
        stepOnBoard(row, column, k, stepBoard);
        return stepBoard[row][column][k] / Math.pow(8, k);
    }

    private double stepOnBoard(int row, int col, int k, double[][][] stepBoard) {
        if(row < 0 || col < 0 || row >= stepBoard.length || col >= stepBoard.length) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (stepBoard[row][col][k] == 0) {
            for (int[] move : moves) {
                stepBoard[row][col][k] += stepOnBoard(row + move[0], col + move[1], k-1, stepBoard);
            }
        }
        return stepBoard[row][col][k];
    }
}
