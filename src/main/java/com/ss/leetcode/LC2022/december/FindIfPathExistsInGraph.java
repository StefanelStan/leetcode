package com.ss.leetcode.LC2022.december;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) {
            return true;
        }
        List<Integer>[] graph = getGraph(n, edges);

        if (graph[source] == null || graph[destination] == null) {
            return false;
        }
        boolean[] seen = new boolean[n];
        traverseGraph(graph, seen, source, source, destination);
        return seen[source] && seen[destination];
    }

    private List<Integer>[] getGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new ArrayList<>();
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    private void traverseGraph(List<Integer>[] graph, boolean[] seen, int position, int source, int destination) {
        if (seen[position]) {
            return;
        }
        seen[position] = true;
        for (int connection : graph[position]) {
            if (!seen[source] || !seen[destination]) {
                traverseGraph(graph, seen, connection, source, destination);
            }
        }
    }
}
