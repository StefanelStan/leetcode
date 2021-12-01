package com.ss.leetcode.LC2021.august;

public class MinimumNumberOpsMoveBallsEachBox {
    // https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
    // Brute force :(
    public int[] minOperations(String boxes) {
        int[] moves = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            moves[i] += calculateLeftMoves(i, boxes);
            moves[i] += calculateRightMoves(i, boxes);
        }
        return moves;
    }

    private int calculateLeftMoves(int endExclusive, String boxes) {
        int moves = 0;
        for (int i = 0; i < endExclusive; i++) {
            if (boxes.charAt(i) == '1') {
                moves += endExclusive - i;
            }
        }
        return moves;
    }

    private int calculateRightMoves(int startExclusive, String boxes) {
        int moves = 0;
        for (int i = startExclusive +1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                moves += i - startExclusive;
            }
        }
        return moves;
    }
}
