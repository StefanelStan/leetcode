package com.ss.leetcode.LC2024.june;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    // https://leetcode.com/problems/magnetic-force-between-two-balls
    /** Algorithm
        1. Sort the positions
        2. Using binary search [1, pos[n-1]], try determining if using a gap of p you can place ALL the balls
        3. Placing balls:
            - traverse array from 1 and if current pos - lastPlacedBall Pos >= selectedDistance, then place the ball there and adjust new index of
                lastPlacedBall and increment numberOfPlacedBalls
            - return numberOfPlacedBalls == m
        4. Return left - 1 of binary search
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1], pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (canPlaceBalls(position, pivot, m)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left - 1;
    }

    private boolean canPlaceBalls(int[] positions, int distance, int ballsToPlace) {
        int placedBalls = 1, lastPlacedBall = positions[0];
        for (int i = 1; i < positions.length && placedBalls < ballsToPlace; i++) {
            if (positions[i] - lastPlacedBall >= distance) {
                lastPlacedBall = positions[i];
                placedBalls++;
            }
        }
        return placedBalls == ballsToPlace;
    }
}
