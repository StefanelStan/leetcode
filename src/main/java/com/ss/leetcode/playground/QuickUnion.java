package com.ss.leetcode.playground;

public class QuickUnion {
    private final int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 1; i < size; i++) {
            root[i] = i;
        }
    }

    public QuickUnion(int size, int[][] edges) {
        this(size);
        for (int[] edge : edges) {
            this.connect(edge[0], edge[1]);
        }
    }

    public int find(int node) {
        if(node < 0 || node >= root.length) {
            return -1;
        }
        while (root[node] != node) {
            node = root[node];
        }
        return root[node];
    }

    public boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public void connect(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 != parent2) {
            root[parent2] = parent1;
        }
    }
}
