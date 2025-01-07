package com.ss.leetcode.LC2021.august;

public class MinimumNumberOpsMoveBallsEachBox {
    // https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
    /** Algorithm
        1. For a position i, you need to move ALL the balls from i-1 to i. This is a prefix sum
        2. Use an int[] minOps to store the result
        3. Traverse from left to right and put the balls into one basked and move them prefix sum)
        4. Traverse from right to left and do the same thing.
     */
    public int[] minOperations(String boxes) {
        int[] minOperations = new int[boxes.length()];
        int accumulatedBalls = boxes.charAt(0) - '0', prevValue = 0;
        for (int i = 1; i < boxes.length(); i++) {
            minOperations[i] += prevValue + accumulatedBalls;
            accumulatedBalls += (boxes.charAt(i) - '0');
            prevValue = minOperations[i];
        }
        if (accumulatedBalls > 0) {
            prevValue = 0;
            accumulatedBalls = boxes.charAt(boxes.length() - 1) - '0';
            for (int i = boxes.length() - 2; i>= 0; i--) {
                prevValue = prevValue + accumulatedBalls;
                minOperations[i] += prevValue;
                accumulatedBalls += (boxes.charAt(i) - '0');
            }
        }
        return minOperations;
    }


    // Brute force :(
    public int[] minOperations2(String boxes) {
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
