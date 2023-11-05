package com.ss.leetcode.LC2023.november;

public class FindTheWinnerOfAnArrayGame {
    // https://leetcode.com/problems/find-the-winner-of-an-array-game
    /** Algorithm
        1. Your winner needs to win k rounds. Thus, it needs to be greater than next k-1 numbers
        2. Set winner = arr[0] and wonRounds to 0;
        3. Loop with i from 1 to n-1 OR until you have won kRound
            - if winner > currentNumber, increase the wonRound.
            - else set your winner to be current number and reset wonRound
        4. Even if you reach the end of the array AND your wonRound is not K, the last number will still
            beat the ones that you have "put" at the back of the array, as the "back" of the array will
            contain only numbers lesser than your current winner.
     */
    public int getWinner(int[] arr, int k) {
        int winner = arr[0], wonRounds = 0;
        for (int i = 1; i < arr.length && wonRounds < k; i++) {
            if (winner > arr[i]) {
                wonRounds++;
            } else {
                winner = arr[i];
                wonRounds = 1;
            }
        }
        return winner;
    }
}
