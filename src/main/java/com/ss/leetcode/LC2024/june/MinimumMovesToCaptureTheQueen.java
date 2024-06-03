package com.ss.leetcode.LC2024.june;

public class MinimumMovesToCaptureTheQueen {
    // https://leetcode.com/problems/minimum-moves-to-capture-the-queen
    /** Algorithm
        1. It is possible that one piece can block other piece:
            - EG: rock cannot go straight and get the queen because bishop is in its way; vice versa
        2. No matter that configuration, the rock can get the queen in 1 or 2 steps
        3. For each piece (rock, bishop) traverse in ALL their 4 correspondant directions and see if they meet the queen.
        4. While travelling, if they meet the other piece, then one extra step will be required to move that piece out of the way
        5. Traverse with both and see if they meet each other or meet the queen.
     */

    private static final int[][] BISHOP_DIRECTIONS = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    private static final int[][] ROCK_DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        return Math.min(
            minMovesFor(a,b,c,d, e,f, ROCK_DIRECTIONS),
            minMovesFor(c,d,a,b, e,f, BISHOP_DIRECTIONS));
    }

    private int minMovesFor(int bi, int bj, int ri, int rj, int qi, int qj, int[][] directions) {
        int min = Integer.MAX_VALUE;
        for (int[] direction : directions) {
            min = Math.min(min, meetTheQueenCost(bi, bj, ri, rj, qi, qj, direction[0], direction[1]));
        }
        return min == 1 ? 1 : 2;
    }

    private int meetTheQueenCost(int bi, int bj, int ri, int rj, int qi, int qj, int xCoeff, int yCoeff) {
        boolean metOther = false;
        for(; bi >= 0 && bi < 9 && bj >= 0 && bj < 9; bi+=xCoeff, bj+=yCoeff) {
            if (bi == ri && bj == rj) {
                metOther = true;
            } else if (bi == qi && bj == qj) {
                return metOther ? 2 : 1;
            }
        }
        return 100;
    }
}
