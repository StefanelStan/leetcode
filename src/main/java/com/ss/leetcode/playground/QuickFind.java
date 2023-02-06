package com.ss.leetcode.playground;

public class QuickFind {
    private final int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for(int i = 1; i < size; i++) {
            root[i] = i;
        }
    }

    public QuickFind(int size, int[][] edges) {
        this(size);
        for (int[] edge : edges) {
            this.connect(edge[0], edge[1]);
        }
    }

    public int find(int node) {
        if (node < 0 || node >= root.length) {
            return -1;
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
            for (int i = 0; i < root.length; i++) {
                if (root[i] == root2) {
                    root[i] = root1;
                }
            }
        }
    }
}
