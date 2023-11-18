package com.ss.leetcode.LC2023.november;

import java.util.HashMap;
import java.util.Map;

public class KnightDialer {
    // https://leetcode.com/problems/knight-dialer
    /** Algorithm
        1. Each position can lead to certain other positions: eg: 0 -> 4,6; 1-> 6,8.
        2. Use an int[][] to pinpoint the allowed jumps from current cell
        3. Use an int[10][n+1] count to cache the number of jumps/phone numbers can be dialled using the given jumps.
        4. EG: From cell 1 with n jumps you can jump to cell 4/6 and have n-1 remaining jumps.
            So jump to cells4/6 with jumps -1 remaining jumps. Determine how many jumps these cells can provide, sum them
            , cache the answer and return it.
        5. From cell 0 you can jump into 4 and 6, but from cell 1 you can also jump into 6.
            So if you are in cell 1 and have k remaining jumps, you will jump into cell 6 with k-1 remaining jumps
            At the same time, when you are in cell 0 and jump into cell 6 with k-1 remaining jumps, as this has already
            been calculated in previous step, just return in.
     */
    private static int[][] allowedMoves = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        int[][] count = new int[10][n+1];
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                total = (total + jumpAndDial(i, count, n)) % 1_000_000_007;
            }
        }
        return n == 1 ? 10 : total;
    }

    private int jumpAndDial(int cell, int[][] count, int jumps) {
        if (jumps == 1) {
            return 1;
        }
        if (count[cell][jumps] == 0) {
            int nextJumps = 0;
            for (int next : allowedMoves[cell]) {
                nextJumps = (nextJumps + jumpAndDial(next, count, jumps - 1)) % 1_000_000_007;
            }
            count[cell][jumps] = nextJumps;
        }
        return count[cell][jumps];
    }

    public int knightDialer2(int n) {
        Map<Integer, Integer>[] count = new Map[10];
        for(int i = 0; i < count.length; i++) {
            count[i] = new HashMap<>();
        }
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                total = (total + jumpAndDial2(i, count, n)) % 1_000_000_007;
            }
        }
        return n == 1 ? 10 : total;
    }

    private int jumpAndDial2(int cell, Map<Integer, Integer>[] count, int jumps) {
        if (jumps == 1) {
            return 1;
        }
        Integer existing = count[cell].get(jumps);
        if (existing == null) {
            int nextJumps = 0;
            for (int next : allowedMoves[cell]) {
                nextJumps = (nextJumps + jumpAndDial2(next, count, jumps - 1)) % 1_000_000_007;
            }
            count[cell].put(jumps, nextJumps);
            return nextJumps;
        } else {
            return existing;
        }
    }
}
