package com.ss.leetcode.LC2022.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLosses {
    // https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    /** Algorithm
        1. Use a Map<Integer, Integer> to mark the losses.
        2. The winner will get an extra loss of 0 (just to insert it in map), while looser will get +1
        3. Traverse Map and if value == 0, insert key into "noLosses", else if value == 1, insert into onlyOneLoss.
        4. Sort the two lists and return them.
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = getLosses(matches);
        return findPlayers(losses);
    }

    private Map<Integer, Integer> getLosses(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        for (int[] match : matches) {
            losses.merge(match[0], 0, Integer::sum);
            losses.merge(match[1], 1, Integer::sum);
        }
        return losses;
    }

    private List<List<Integer>> findPlayers(Map<Integer, Integer> losses) {
        List<Integer> notLostAnyMatch = new ArrayList<>();
        List<Integer> lostOneMatch = new ArrayList<>();
        losses.forEach((k, v) -> {
            if (v == 0) {
                notLostAnyMatch.add(k);
            } else if (v == 1) {
                lostOneMatch.add(k);
            }
        });
        Collections.sort(notLostAnyMatch);
        Collections.sort(lostOneMatch);
        return List.of(notLostAnyMatch, lostOneMatch);
    }

    /** Algorithm
         1. Use a tree map player -> int[2] stats to input the details of each match/players
            playerId -> [wins, losses]
         2. Traverse each match and update the map with players stats
         3. Traverse the map (being tree map, the player order is guaranteed) and check the stats:
            - add the playerId to a notLost list if player has not lost stats[0] > 0 && stats[1]==0
             - add the playerId to lostOneMatch list if stats[1] == 1
         4. Return a list of these two lists
     */
    // You only need to track the losses. for a victory, insert (computeIfAbsent) with 0 as loss.
    public List<List<Integer>> findWinners2(int[][] matches) {
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
