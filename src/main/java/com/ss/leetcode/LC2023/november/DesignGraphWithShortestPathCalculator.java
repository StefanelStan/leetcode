package com.ss.leetcode.LC2023.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignGraphWithShortestPathCalculator {
    // https://leetcode.com/problems/design-graph-with-shortest-path-calculator
    // NEEDS FIXING
    private List<Destination>[] destinations;
    public DesignGraphWithShortestPathCalculator(int n, int[][] edges) {
        destinations = new List[n];
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        if (destinations[edge[0]] == null) {
            destinations[edge[0]] = new ArrayList<>();
        }
        destinations[edge[0]].add(new Destination(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        boolean[] visited = new boolean[destinations.length];
        int[] pathCost = new int[visited.length];
        Arrays.fill(pathCost, -2);
        pathCost[node1] = -2;
        return traverse(node1, node2, visited, pathCost);
    }

    private int traverse(int currentNode, int targetNode, boolean[] visited, int[] pathCost) {
        if (currentNode == targetNode) {
            return 0;
        }
        if (visited[currentNode]) {
            return pathCost[currentNode] == -2
                ? -1
                : pathCost[currentNode] == -1 ? -1 : pathCost[currentNode];
        }
        visited[currentNode] = true;
        int candidateCost, bestCost = Integer.MAX_VALUE;
        pathCost[currentNode] = -1;
        if(destinations[currentNode] != null) {
            for (Destination d : destinations[currentNode]) {
                candidateCost = traverse(d.to, targetNode, visited, pathCost);
                if (candidateCost >= 0) {
                    bestCost = Math.min(bestCost, candidateCost + d.cost);
                }
            }
            if (bestCost != Integer.MAX_VALUE) {
                pathCost[currentNode] = bestCost;
            }
        }
        return pathCost[currentNode];
    }

    private static class Destination {
        int to;
        int cost;

        public Destination(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
