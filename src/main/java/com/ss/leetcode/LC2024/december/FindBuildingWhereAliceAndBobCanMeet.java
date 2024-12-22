package com.ss.leetcode.LC2024.december;

import java.util.List;
import java.util.ArrayList;

public class FindBuildingWhereAliceAndBobCanMeet {
    // https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet
    // TODO TLE
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<Integer>[] nextHighestBuildings = getNextHighestBuildings(heights);
        int[] meetingBuildings = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            meetingBuildings[i] = findMeetingBuilding(queries[i][0], queries[i][1], heights, nextHighestBuildings);
        }
        return meetingBuildings;
    }

    private int findMeetingBuilding(int a, int b, int[] heights, List<Integer>[] nextHighestBuildings) {
        if (a == b) {
            return a;
        }
        int minB = Math.min(a,b);
        int maxB = Math.max(a,b);
        if (heights[maxB] > heights[minB]) {
            return maxB;
        }
        if (nextHighestBuildings[a].isEmpty() || nextHighestBuildings[b].isEmpty()) {
            return -1;
        }
        for (int i = 0, j = 0; i < nextHighestBuildings[a].size() && j < nextHighestBuildings[b].size();) {
            if (nextHighestBuildings[a].get(i).intValue() == nextHighestBuildings[b].get(j).intValue()) {
                return nextHighestBuildings[a].get(i);
            } else if (nextHighestBuildings[a].get(i) < nextHighestBuildings[b].get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    private List<Integer>[] getNextHighestBuildings(int[] heights) {
        List<Integer>[] nextHighestBuildings = new List[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            nextHighestBuildings[i] = new ArrayList<>();
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    nextHighestBuildings[i].add(j);
                }
            }
        }
        return nextHighestBuildings;
    }
}
