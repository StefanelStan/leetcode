package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public int shortestPathCost(int nodes, int[][] edges, int source, int destination) {
        int[] lowestCost = new int[nodes];
        Arrays.fill(lowestCost, Integer.MAX_VALUE);
        lowestCost[source] = 0;
        int[] predecessors = new int[nodes];

        boolean updated = true;
        for (int i = 0; i < nodes -1 && updated; i++) {
            updated = false;
            for (int[] edge : edges) {
                if (lowestCost[edge[0]] != Integer.MAX_VALUE && lowestCost[edge[0]] + edge[2] < lowestCost[edge[1]]) {
                    updated = true;
                    lowestCost[edge[1]] = lowestCost[edge[0]] + edge[2];
                    predecessors[edge[1]] = edge[0];
                }
            }
        }

        if (lowestCost[destination] != Integer.MAX_VALUE) {
            System.out.println(getPath(predecessors, source, destination).reversed());
        }
        return lowestCost[destination];
    }

    private List<Integer> getPath(int[] predecessors, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        path.add(destination);
        while (source != destination) {
            path.add(predecessors[destination]);
            destination = predecessors[destination];
        }
        return path;
    }
}
