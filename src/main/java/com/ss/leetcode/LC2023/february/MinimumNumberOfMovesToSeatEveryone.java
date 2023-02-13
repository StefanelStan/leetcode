package com.ss.leetcode.LC2023.february;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    // https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
    /** Algorithm
        1. Sort students and seats.
        2. For each i (0, n-1), determine the nr of moves needed to move student[i] to seat[i] (Math.abs(diff)).
        3. Add this diff to the answer.
        4. Return the answer;
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        int minMoves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            minMoves += (Math.abs(seats[i] - students[i]));
        }
        return minMoves;
    }
}
