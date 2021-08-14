package com.ss.leetcode.august;

public class ShortestDistanceToACharacter {
    // https://leetcode.com/problems/shortest-distance-to-a-character/
    public int[] shortestToChar(String s, char c) {
        int[] distances = new int[s.length()];
        int lastKnownPosition = -100_000_000;
        int currentMin = 0;
        for (int i = 0; i < s.length(); i++) {
            distances[i] = i - lastKnownPosition;
            if (s.charAt(i) == c) {
                lastKnownPosition = i;
                for (int j = i; j >= 0; j--) {
                    currentMin = Math.min(lastKnownPosition - j, distances[j]);
                    if (currentMin < distances[j]) {
                        distances[j] = currentMin;
                    } else {
                        break;
                    }
                }
            }
        }
        return distances;
    }
}
