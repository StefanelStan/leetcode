package com.ss.leetcode.LC2022.april;

import java.util.Arrays;
import java.util.Comparator;

public class MinCostToConnectAllPoints {
    // https://leetcode.com/problems/min-cost-to-connect-all-points/
    // Minimum Spanning Tree MST
    /** Algorithm
        1. Compute the distances of ALL the nodes from [0..n-2] to j [i+1..n-1] and sort them
        2. Starting from 1st distance (closest), if the two nodes are not connected (in same connected component) connect them and add the dist
        3. Stop when the UnionFind number of connections == nodes - 1;
     */
    // WORKS NOW :)
    public int minCostConnectPoints(int[][] points) {
        int[][] sortedDistances = getSortedDistances(points);
        UnionFind uf = new UnionFind(points.length);
        int minCost = 0;
        System.out.println(Arrays.deepToString(sortedDistances));
        for (int i = 0; i < sortedDistances.length && !uf.isFullyConnected(); i++) {
            if (uf.connect(sortedDistances[i][0], sortedDistances[i][1])) {
                minCost += sortedDistances[i][2];
            }
        }
        return minCost;
    }

    private int[][] getSortedDistances(int[][] points) {
        int[][] sortedDistances = new int[(points.length * (points.length -1)) / 2][3];
        int insertIndex = 0, i, j;
        for (i = 0; i < points.length - 1; i++) {
            for (j = i + 1; j < points.length; j++) {
                sortedDistances[insertIndex++] = new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])};
            }
        }
        Arrays.sort(sortedDistances, Comparator.comparingInt(a -> a[2]));
        return sortedDistances;
    }

    private static class UnionFind {
        int[] root;
        int connections;

        public UnionFind(int n) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        public boolean isFullyConnected() {
            return connections == root.length - 1;
        }

        public boolean connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
                connections++;
                return true;
            }
            return false;
        }

        public int find(int node) {
            if (node != root[node]) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }


    public int minCostConnectPoints2(int[][] points) {
        if(points.length == 1) {
            return 0;
        }
        boolean[] connected = new boolean[points.length];
        int minCost = 0;
        for (int i = 0; i < points.length; i++) {
            if (!connected[i]) {
                minCost += connect(i, points, connected);
            }
        }
        return minCost;
    }

    private int connect(int pointIndex, int[][] points, boolean[] connected) {
        int connection = 0, tempDistance;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (i != pointIndex) {
                tempDistance = Math.abs(points[pointIndex][0] - points[i][0]) + Math.abs(points[pointIndex][1] - points[i][1]);
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    connection = i;
                }
            }
        }
        connected[pointIndex] = true;
        connected[connection] = true;
        return minDistance;
    }
}
