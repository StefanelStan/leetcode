package com.ss.leetcode.LC2023.february;

public class RedundantConnection {
    // https://leetcode.com/problems/redundant-connection/
    /** Algorithm
         1. The first redundant connection is the first connection that creates a cycle in the graph
         2. This is done when the vertex1 and vertex2 of that edge has the same root.
         3. Traverse and build/connect the vertices via edges.
            When first edge has both vertices connected to the same root, stop and return.
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] root = generateRoot(edges);
        for (int[] edge : edges) {
            int root1 = find(root, edge[0]);
            int root2 = find(root, edge[1]);
            if (root1 == root2) {
                return edge;
            } else {
                root[root2] = root1;
            }
        }
        return new int[]{-1,-1};
    }

    private int[] generateRoot(int[][] edges) {
        int[] root = new int[edges.length  + 1];
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
        return root;
    }

    private int find(int[] root, int node) {
        while (node != root[node]) {
            node = root[node];
        }
        return node;
    }
}
