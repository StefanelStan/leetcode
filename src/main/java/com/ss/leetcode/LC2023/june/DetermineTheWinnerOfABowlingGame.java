package com.ss.leetcode.LC2023.june;

public class DetermineTheWinnerOfABowlingGame {
    // https://leetcode.com/problems/determine-the-winner-of-a-bowling-game
    /** Algorithm
        1. Traverse the two arrays, keeping track of player1/2 score and last index for p1/2 when they hit 10
        2. For each player, if the diff between i and lastIndexOf10Pin <= 2, add the score twice, else single time
        3. Return the player who won.
     */
    public int isWinner(int[] player1, int[] player2) {
        int playerOneScore = 0, playerTwoScore = 0;
        int lastPlayerOneTen = -100, lastPlayerTwoTen = -100;
        for (int i = 0; i < player1.length; i++) {
            playerOneScore += i - lastPlayerOneTen <= 2 ? 2 * player1[i] : player1[i];
            if (player1[i] == 10) {
                lastPlayerOneTen = i;
            }
            playerTwoScore += i - lastPlayerTwoTen <= 2 ? 2 * player2[i] : player2[i];
            if (player2[i] == 10) {
                lastPlayerTwoTen = i;
            }
        }
        return playerOneScore > playerTwoScore ? 1 : playerOneScore < playerTwoScore ? 2 : 0;
    }
}
