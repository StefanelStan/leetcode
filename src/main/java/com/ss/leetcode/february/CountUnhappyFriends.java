package com.ss.leetcode.february;

import java.util.HashMap;
import java.util.Map;

public class CountUnhappyFriends {
    // https://leetcode.com/problems/count-unhappy-friends/
    public int unhappyFriends(int friends, int[][] preferences, int[][] pairs) {
        final Map<Integer, Integer> pairsMap = getPairsMap(pairs);
        int unhappyFriends = 0;
        for(int[] pair : pairs) {
            if(isPairedUnhappily(pairsMap, preferences, pair[0], pair[1])) {
                unhappyFriends++;
            }
            if(isPairedUnhappily(pairsMap, preferences, pair[1], pair[0])) {
                unhappyFriends++;
            }
        }
        return unhappyFriends;
    }

    private Map<Integer, Integer> getPairsMap(int[][] pairs) {
        final Map<Integer, Integer> pairsMap = new HashMap<>();
        for(int[] pair : pairs) {
            pairsMap.put(pair[0], pair[1]);
            pairsMap.put(pair[1], pair[0]);
        }
        return pairsMap;
    }

    private boolean isPairedUnhappily(Map<Integer, Integer> pairsMap, int[][] preferences, int first, int second) {
        if (preferences[first][0] == second) {
            return false;
        } else {
            int pairOfNextPreferred;
            for (int i = 0; i < preferences[first].length && preferences[first][i] != second; i++) {
                pairOfNextPreferred = pairsMap.get(preferences[first][i]);
                if(isFirstFriendPreferredToOther(preferences[preferences[first][i]], first, pairOfNextPreferred)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFirstFriendPreferredToOther(int[] preference, int first, int other) {
        for (int preferredFriend : preference) {
            if (preferredFriend == first) {
                return true;
            }
            if(preferredFriend == other) {
                return false;
            }
        }
        return false;
    }
}
