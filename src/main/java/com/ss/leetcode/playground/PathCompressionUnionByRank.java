package com.ss.leetcode.playground;

public class PathCompressionUnionByRank {
    private int[] root;
    private int[] rank;

    public PathCompressionUnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public PathCompressionUnionByRank(int size, int[][] edges) {
        this(size);
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public void connect(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                root[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                root[root1] = root2;
            } else {
                root[root2] = root1;
                rank[root1]++;
            }
        }
    }

    public boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int find(int node) {
        if (root[node] == node) {
            return node;
        }
        int found = find(root[node]);
        root[node] = found;
        return found;
    }
}
