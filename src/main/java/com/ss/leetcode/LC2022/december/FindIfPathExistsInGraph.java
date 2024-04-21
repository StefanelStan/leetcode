package com.ss.leetcode.LC2022.december;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {
    // https://leetcode.com/problems/find-if-path-exists-in-graph
    /** Algorithm
        1. Fail fast: return true if source == destination
        2. For two vertices to be connected, they need to belong to the same set (Union Find)
        3. Connect each two edges from the list of edges
        4. Return true if (source, destination) are connected/part of the same set/ have same root.
     */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.connect(edge[0], edge[1]);
        }
        return uf.areConnected(source, destination);
    }

    private static class UnionFind {
        int[] root;

        public UnionFind(int n) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        public void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        public boolean areConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        private int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }

    public boolean validPath2(int n, int[][] edges, int source, int destination) {
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
