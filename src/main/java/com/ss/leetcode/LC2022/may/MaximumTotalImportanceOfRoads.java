package com.ss.leetcode.LC2022.may;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumTotalImportanceOfRoads {
    // https://leetcode.com/problems/maximum-total-importance-of-roads/
    /** Algorithm
        1. Use an int[] to mark the indegree/outdegree of each city: [a,b] -> cityImportance[a]++ and cityImportance[b]++;
        2. Sort ASC the cityImportance. Each indegree means there is an edge coming in/out from that city, so it's
            importance will be multiplied with its indegree.
        3. Starting from the back, multiply and add each cityImportance with it's index. The index will be the unique value (n to 1)
     */
    public long maximumImportance(int n, int[][] roads) {
        long maxImportance = 0;
        int[] cityImportance = new int[n];
        for (int[] road : roads) {
            cityImportance[road[0]]++;
            cityImportance[road[1]]++;
        }
        Arrays.sort(cityImportance);
        for (int i = n -1; i >= 0; i--) {
            maxImportance += ((long)(i + 1) * cityImportance[i]);
        }
        return maxImportance;
    }

    // INEFFICIENT
    public long maximumImportance2(int n, int[][] roads) {
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
