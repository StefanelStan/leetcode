package com.ss.leetcode.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    // https://leetcode.com/problems/finding-the-users-active-minutes/
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMinutes = new HashMap<>();
        for (int[] log : logs) {
            if (userMinutes.containsKey(log[0])) {
                userMinutes.get(log[0]).add(log[1]);
            } else {
                Set<Integer> minutes = new HashSet<>();
                minutes.add(log[1]);
                userMinutes.put(log[0], minutes);
            }
        }
        final int[] activeMinutes = new int[k];
        userMinutes.forEach((key, value) -> {
            activeMinutes[value.size() - 1]++;
        });
        return activeMinutes;
    }
}
