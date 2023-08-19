package com.ss.leetcode.LC2023.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
    // https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
    // Kruskal's Algorithm To Deep Dive
    // TLE
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[] minCriticalMST = {Integer.MAX_VALUE, 0};
        int[] globalPresentEdges = new int[edges.length];
        int[][] sortedEdges = getSortedEdges(edges);
        DisjointSet ds = new DisjointSet(n, edges.length);
        addEdges(sortedEdges, 0, ds, globalPresentEdges, minCriticalMST);
        return getCriticalAndPseudoCriticalEdges(globalPresentEdges, sortedEdges, minCriticalMST[1]);
    }

    private void addEdges(int[][] sortedEdges, int index, DisjointSet ds, int[] globalPresentEdges, int[] minCriticalMST) {
        if (ds.isFullyConnected()) {
            setGlobalAndCriticalMST(ds, globalPresentEdges, minCriticalMST);
            return;
        } else if (index > sortedEdges.length || sortedEdges.length - index < ds.remainingEdgesToConnect() || ds.totalCost > minCriticalMST[0]) {
            return;
        }
        // add it if possible
        if (ds.canConnect(sortedEdges[index][0], sortedEdges[index][1])) {
            int[] clone = Arrays.copyOf(ds.root, ds.root.length);
            ds.connect(sortedEdges[index][0], sortedEdges[index][1], sortedEdges[index][2], index);
            addEdges(sortedEdges, index + 1, ds, globalPresentEdges, minCriticalMST);
            // disconnect it
            ds.disconnect(sortedEdges[index][0], sortedEdges[index][1], sortedEdges[index][2], index);
            ds.root = clone;
        }
        addEdges(sortedEdges, index + 1, ds, globalPresentEdges, minCriticalMST);
        //skip it
    }

    private void setGlobalAndCriticalMST(DisjointSet ds, int[] globalPresentEdges, int[] minCriticalMST) {
        if (ds.totalCost < minCriticalMST[0]) {
            minCriticalMST[0] = ds.totalCost;
            minCriticalMST[1] = 1;
            for (int i = 0; i < globalPresentEdges.length; i++) {
                globalPresentEdges[i] = ds.presentEdges[i] ? 1 : 0;
            }
        } else if (ds.totalCost == minCriticalMST[0]) {
            minCriticalMST[1]++;
            for (int i = 0; i < globalPresentEdges.length; i++) {
                if(ds.presentEdges[i]) {
                    globalPresentEdges[i]++;
                }
            }
        }
    }

    private List<List<Integer>> getCriticalAndPseudoCriticalEdges(int[] globalPresentEdges, int[][] sortedEdges, int mstCount) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for (int i = 0; i < globalPresentEdges.length; i++) {
            if (globalPresentEdges[i] == mstCount) {
                critical.add(sortedEdges[i][3]);
            } else if (globalPresentEdges[i] > 0){
                pseudoCritical.add(sortedEdges[i][3]);
            }
        }
        return List.of(critical, pseudoCritical);
    }

    private int[][] getSortedEdges(int[][] edges) {
        int[][] sortedEdges = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            sortedEdges[i][0] = edges[i][0];
            sortedEdges[i][1] = edges[i][1];
            sortedEdges[i][2] = edges[i][2];
            sortedEdges[i][3] = i;
        }
        Arrays.sort(sortedEdges, Comparator.comparingInt(e -> e[2]));
        return sortedEdges;
    }

    private void countPresentEdges(DisjointSet ds, int[] globalPresentEdges) {
        for(int i = 0; i < globalPresentEdges.length; i++) {
            if (ds.presentEdges[i]) {
                globalPresentEdges[i]++;
            }
        }
    }

    private static class DisjointSet {
        int[] root;
        int existingEdges;
        boolean[] presentEdges;
        int totalCost;

        public DisjointSet(int n, int numberOfEdges) {
            root = new int[n];
            presentEdges = new boolean[numberOfEdges];
            while(--n > 0) {
                root[n] = n;
            }
        }

        public void connect(int node1, int node2, int edgeCost, int edgeIndex) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
                presentEdges[edgeIndex] = true;
                totalCost += edgeCost;
                existingEdges++;
            }
        }

        private boolean canConnect(int node1, int node2) {
            return find(node1) != find(node2);
        }

        public void disconnect(int node1, int node2, int edgeCost, int edgeIndex) {
            root[node2] = node2;
            presentEdges[edgeIndex] = false;
            existingEdges--;
            totalCost -= edgeCost;
        }

        public int find(int node) {
            while(root[node] != node) {
                node = root[node];
            }
            return node;
        }

        public boolean isFullyConnected() {
            return existingEdges == root.length - 1;
        }

        public int remainingEdgesToConnect() {
            return root.length - 1 - existingEdges;
        }

    }
}
