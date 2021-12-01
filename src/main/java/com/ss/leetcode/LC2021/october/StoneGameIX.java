package com.ss.leetcode.LC2021.october;

import java.util.stream.IntStream;

public class StoneGameIX {
    // https://leetcode.com/contest/weekly-contest-261/problems/stone-game-ix/
    public boolean stoneGameIX(int[] stones) {
        // Alice Wins or Alice can win
        int sum = IntStream.of(stones).sum();
        //        if (sum % 3 == 0) {
        //            return true;
        //        }
        boolean[] aliceVictory = { false };

        int leftIndex = 0, rightIndex = stones.length - 1;

        playTheGame(1, 0, stones, leftIndex, rightIndex, aliceVictory);
        return aliceVictory[0];
    }

    private void playTheGame(int turn, int sumSoFar, int[] stones, int leftIndex, int rightIndex,
                             boolean[] aliceVictory) {
        if (!aliceVictory[0]) {
            if (leftIndex > rightIndex) {
                return;
            }
            // if Alice turn
            if (turn == 1) {
                if ((sumSoFar + stones[leftIndex]) % 3 == 0 && (sumSoFar + stones[rightIndex]) % 3 == 0) {
                    aliceVictory[0] = false;
                    return;
                }
                if (sumSoFar + stones[leftIndex] % 3 == 0) {
                    playTheGame(2, sumSoFar + stones[leftIndex], stones, leftIndex + 1, rightIndex, aliceVictory);
                }
                if (!aliceVictory[0]) {
                    playTheGame(2, sumSoFar + stones[rightIndex], stones, leftIndex, rightIndex - 1, aliceVictory);
                }
            } else {
                // Bob turn
                if ((sumSoFar + stones[leftIndex]) % 3 == 0 && (sumSoFar + stones[rightIndex]) % 3 == 0) {
                    aliceVictory[0] = true;
                    return;
                }
                if ((sumSoFar + stones[leftIndex]) % 3 == 0) {
                    playTheGame(1, sumSoFar + stones[rightIndex], stones, leftIndex, rightIndex - 1, aliceVictory);
                }
                if (!aliceVictory[0]) {
                    playTheGame(1, sumSoFar + stones[leftIndex], stones, leftIndex + 1, rightIndex, aliceVictory);
                }
            }
        }
    }
}
