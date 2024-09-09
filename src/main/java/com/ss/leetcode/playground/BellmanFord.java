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

        runCycle(nodes, edges, false, lowestCost, predecessors);

        if (lowestCost[destination] != Integer.MAX_VALUE && lowestCost[destination] != Integer.MIN_VALUE) {
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

    public int shortestPathCostWithNegativeCycle(int nodes, int[][] edges, int source, int destination) {
        int[] lowestCost = new int[nodes];
        Arrays.fill(lowestCost, Integer.MAX_VALUE);
        lowestCost[source] = 0;
        int[] predecessors = new int[nodes];

        boolean updated = true;
        // run normal cycle
        runCycle(nodes, edges,false, lowestCost, predecessors);
        // run negative cycle detection
        runCycle(nodes, edges, true, lowestCost, predecessors);

        if (lowestCost[destination] != Integer.MAX_VALUE && lowestCost[destination] != Integer.MIN_VALUE) {
            System.out.println(getPath(predecessors, source, destination).reversed());
        }

        return lowestCost[destination];
    }

    private void runCycle(int nodes, int[][] edges, boolean isNegativeCycleRun, int[] lowestCost, int[] predecessors) {
        boolean updated = true;
        for (int i = 0; i < nodes -1 && updated; i++) {
            updated = false;
            for (int[] edge : edges) {
                if (lowestCost[edge[0]] != Integer.MAX_VALUE && lowestCost[edge[0]] + edge[2] < lowestCost[edge[1]]) {
                    updated = true;
                    lowestCost[edge[1]] = isNegativeCycleRun ? Integer.MIN_VALUE : lowestCost[edge[0]] + edge[2];
                    predecessors[edge[1]] = edge[0];
                }
            }
        }
    }
}
