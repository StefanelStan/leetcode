package com.ss.leetcode.LC2024.april;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
    // https://leetcode.com/problems/maximum-matching-of-players-with-trainers
    /** Algorithm
        1. Sort the players and the trainers
        2. Use two pointers i and j over players and trainers
            - If players[i] <= trainers[j], then you have a match. Advance i
            - Else, check if next trainers can be matched with current players.
        3. Return total number of matches
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int matches = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        for (int i = 0, j = 0; i < players.length && j < trainers.length; j++) {
            if (players[i] <= trainers[j]) {
                i++;
                matches++;
            }
        }
        return matches;
    }
}
