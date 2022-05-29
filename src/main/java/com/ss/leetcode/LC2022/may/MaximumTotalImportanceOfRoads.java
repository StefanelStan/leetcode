package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumTotalImportanceOfRoads {
    // https://leetcode.com/problems/maximum-total-importance-of-roads/
    public long maximumImportance(int n, int[][] roads) {
        int[][] cities = new int[n][3];
        for(int i = 0; i < cities.length; i++) {
            cities[i][0] = i;
        }
        for (int[] road : roads) {
            cities[road[0]][1]++;
            cities[road[1]][1]++;
        }
        Arrays.sort(cities, Comparator.comparingInt(a -> a[1]));
        for (int i = cities.length -1; i >= 0; i--) {
            cities[i][2] = i + 1;
        }
        Arrays.sort(cities, Comparator.comparingInt(a -> a[0]));
        long totalImportance = 0;
        for(int[] road : roads) {
            totalImportance += cities[road[0]][2] + cities[road[1]][2];
        }
        return totalImportance;
    }
}
