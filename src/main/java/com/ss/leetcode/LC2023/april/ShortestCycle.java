package com.ss.leetcode.LC2023.april;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestCycle {
    private Set[] vertexRanks;
    public int findShortestCycle(int n, int[][] edges) {
        vertexRanks = new HashSet[n];
        for (int i = 0; i < n; i++) {
            vertexRanks[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
        return findShortestCycle();
    }

    private void connect(int x, int y) {
        vertexRanks[x].add(y);
        vertexRanks[y].add(x);
    }

    private int findShortestCycle() {
        int shortestCycle = Integer.MAX_VALUE;
        for (int i = 0; i < vertexRanks.length; i++) {
            int[] distances = new int[vertexRanks.length];
            int[] parents = new int[vertexRanks.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            shortestCycle = visitVetices(shortestCycle, distances, parents, q);
        }
        return (shortestCycle == Integer.MAX_VALUE ? -1 : shortestCycle);
    }

    private int visitVetices(int shortestCycle, int[] distances, int[] parents, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int x = q.poll();
            Set<Integer> children = vertexRanks[x];
            for (int child : children) {
                if (distances[child] == 0) {
                    distances[child] = 1 + distances[x];
                    parents[child] = x;
                    q.add(child);
                } else if (parents[x] != child && parents[child] != x) {
                    shortestCycle = Math.min(shortestCycle, distances[x] + distances[child] + 1);
                }
            }
        }
        return shortestCycle;
    }
}
