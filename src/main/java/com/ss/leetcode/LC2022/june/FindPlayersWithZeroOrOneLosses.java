package com.ss.leetcode.LC2022.june;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLosses {
    // https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    /** Algorithm
         1. Use a tree map player -> int[2] stats to input the details of each match/players
            playerId -> [wins, losses]
         2. Traverse each match and update the map with players stats
         3. Traverse the map (being tree map, the player order is guaranteed) and check the stats:
            - add the playerId to a notLost list if player has not lost stats[0] > 0 && stats[1]==0
             - add the playerId to lostOneMatch list if stats[1] == 1
         4. Return a list of these two lists
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        // [0] will track victories and [1] losses
        Map<Integer, int[]> scores = new TreeMap<>();
        final List<Integer> notLost = new ArrayList<>(matches.length);
        final List<Integer> lostOneMatch = new ArrayList<>(matches.length);
        for (int[] match : matches) {
            int[] winner = scores.computeIfAbsent(match[0], k -> new int[]{0,0});
            winner[0]++;
            int[] loser = scores.computeIfAbsent(match[1], k -> new int[]{0,0});
            loser[1]++;
        }
        scores.forEach((k, v) -> {
            if (v[1] == 0 && v[0] > 0) {
                notLost.add(k);
            } else if (v[1] == 1) {
                lostOneMatch.add(k);
            }
        });
        return List.of(notLost, lostOneMatch);
    }
}
