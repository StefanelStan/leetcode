package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    // https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
    /** Algorithm
        1. The solution is actually to look at the problem as its two different graphs: Alice and Bob.
        2. Sort the edges in reverse order by type (3,2,1). It is vital to add the shared edges(3) first.
        3. Use 2 UnionFinds (graphs) to add the edges to. 3 will be added to alice and bob, 2 only to bob and 1 to only alice.
        4. The method to add an edge (connect two vertices) will return 1 or
            0: if the two vertices are already part of the same component, then the edge is not needed and can be disregarded. (removed + 1).
            - Also, keep track of the number of edgs alice / bob graph have.
            - A connected graph (no disconnected components) should have n-1 unique edges to connect the n vertices. (if graph has less than n-1 edges, it means some nodes/components are not connected)
        5. Add the edges to the graphs and count the number of disregarded edges.
        6. The last condition: if Alice / Bob can fully traverse the graph: this means Alice and Bob graphs need to have just 1 single connected component. If A or B have 2 or more disconnected components, then they cannot traverse the graph => return -1.
            - Check explanation from #4
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b) -> b[0] - a[0]);
        UnionFind bobGraph = new UnionFind(n);
        UnionFind aliceGraph = new UnionFind(n);
        int duplicatedEdges = connectVertices(aliceGraph, bobGraph, edges);
        return canBeFullyTraversed(aliceGraph, bobGraph) ? duplicatedEdges : -1;
    }

    public boolean canBeFullyTraversed(UnionFind aliceGraph, UnionFind bobGraph) {
        return aliceGraph.isFullyConnected() && bobGraph.isFullyConnected();
    }

    private int connectVertices(UnionFind aliceGraph, UnionFind bobGraph, int[][] edges) {
        int duplicatedEdges = 0;
        int duplicatedEdge;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                duplicatedEdge = bobGraph.connect(edge[1], edge[2]);
                if (duplicatedEdge == 0) {
                    aliceGraph.connect(edge[1], edge[2]);
                }
            } else if (edge[0] == 1) {
                duplicatedEdge = aliceGraph.connect(edge[1], edge[2]);
            } else {
                duplicatedEdge = bobGraph.connect(edge[1], edge[2]);
            }
            duplicatedEdges += duplicatedEdge;
        }
        return duplicatedEdges;
    }


    private static class UnionFind {
        int[] root;
        int[] rank;
        int edges;
        public UnionFind(int n) {
            root = new int[n + 1];
            rank = new int[n + 1];
            while(--n >= 0) {
                root[n] = n;
                rank[n] = 1;
            }
        }

        public int connect(int node1, int node2) {
            int duplicated = 1;
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                edges++;
                duplicated = 0;
                if (rank[root1] > rank[root2]) {
                    root[root2] = root1;
                } else if (rank[root1] < rank[root2]) {
                    root[root1] = root2;
                } else {
                    root[root2] = root1;
                    rank[root1]++;
                }
            }
            return duplicated;
        }

        public boolean isFullyConnected() {
            return rank.length == edges + 2;
        }

        private int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
