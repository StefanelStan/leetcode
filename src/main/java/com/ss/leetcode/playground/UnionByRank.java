package com.ss.leetcode.playground;

public class UnionByRank {
    private int[] root;
    private int[] rank;

    public UnionByRank(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public UnionByRank(int size, int[][] edges) {
        this(size);
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public int find(int node) {
        if (node < 0 || node >= root.length) {
            return -1;
        }
        while (root[node] != node) {
            node =root [node];
        }
        return root[node];
    }

    public boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public void connect(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            if (rank[root1] == rank[root2]) {
                root[root2] = root1;
                rank[root1]++;
            } else if (rank[root1] > rank[root2]) {
                root[root2] = root1;
            } else {
                root[root1] = root2;
            }
        }
    }
}
