package com.ss.leetcode.LC2024.october;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    // https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i
    /** Algorithm
        1. Each node i will link to i + 1, but each query can link it to further nodes.
        2. For each query, add the list of shortcuts of node[i] to other nodes in a list queryPaths.
        3. Apply BFS, adding the next visited nodes. Stop when you reach node n-1 first time.
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] queryPaths = new List[n];
        int[] distances = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queryPaths[queries[i][0]] == null) {
                queryPaths[queries[i][0]] = new ArrayList<>();
            }
            queryPaths[queries[i][0]].add(queries[i][1]);
            distances[i] = findMinDistance(queryPaths);
        }
        return distances;
    }

    private int findMinDistance(List<Integer>[] queryPaths) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(0);
        boolean[] visited = new boolean[queryPaths.length];
        int minDistance = 0, size;
        Integer next;
        while (!nodes.isEmpty()) {
            size = nodes.size();
            while (size > 0) {
                next = nodes.poll();
                if (next == queryPaths.length - 1) {
                    return minDistance;
                }
                if (!visited[next + 1]) {
                    visited[next] = true;
                    nodes.add(next + 1);
                }
                addShortcutsToQueue(queryPaths[next], nodes, visited);
                size--;
            }
            minDistance++;
        }
        return minDistance;
    }

    private void addShortcutsToQueue(List<Integer> nextNodes, Queue<Integer> nodes, boolean[] visited) {
        if (nextNodes != null) {
            for (int neighbour : nextNodes) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    nodes.add(neighbour);
                }
            }
        }
    }
}
