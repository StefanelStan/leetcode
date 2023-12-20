package com.ss.leetcode.LC2023.december;

public class FindChampionII {
    // https://leetcode.com/problems/find-champion-ii
    /** Algorithm
        1. Build a boolean[n] losses to flag which team has lost:
        2. Mark each edge[1] with true in the array: [2,5] => losses[5] = true.
        3. Traverse losses and if the current index has not lost, mark the index.
        4. If encountering another index of losses that has not lost, then you have two teams that did not lose.
            So return -1;
     */
    public int findChampion(int n, int[][] edges) {
        boolean[] losses = getLosses(n, edges);
        return findWinner(losses);
    }

    private int findWinner(boolean[] losses) {
        int winner = -1;
        for (int i = 0; i < losses.length; i++) {
            if (!losses[i]) {
                if (winner != -1) {
                    return -1;
                } else {
                    winner = i;
                }
            }
        }
        return winner;
    }

    private boolean[] getLosses(int n, int[][] edges) {
        boolean[] losses = new boolean[n];
        for(int[] edge : edges) {
            losses[edge[1]] = true;
        }
        return losses;
    }
}
