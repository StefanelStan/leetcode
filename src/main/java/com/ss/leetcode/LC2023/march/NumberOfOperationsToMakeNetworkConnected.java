package com.ss.leetcode.LC2023.march;

public class NumberOfOperationsToMakeNetworkConnected {
    // https://leetcode.com/problems/number-of-operations-to-make-network-connected
    /** Algorithm
        1. In order to "connect all computers" you need to know how many groups of "unconnected" computers you have.
           This means disconnected components or disjoint set.
           EG: n=4 edges = [[0,1],[0,2],[1,2]] => You have 2 disconnected components[0,1,2] and [3].
        2. If you have x disconnected components, then you need x-1 edges to connect all of these.
        3. A graph is/can be fully connected (so you have 1 single component) if you have at least n-1 edges to connect the n nodes.
        4. Given n and the edges, determine the number of disjoint sets. If the number is 1, then all nodes are connected,
           so your answer is 0.
        5. If you have x components (so x disconnected components), you need x-1 edges to connect them.
           But do you have sufficient edges in the given set of edges? point #3
        6. If your have less than n-1 edges/connections, then you cannot connect the disconnected components, so return -1.
           Else return the number of disconnected components - 1. (eg:5 components can be connected via 4 edges)
     */
    private UnionFind uf;
    public int makeConnected(int n, int[][] connections) {
        uf = new UnionFind(n, connections);
        int components = uf.countComponents();
        if (components == 1) {
            return 0;
        } else {
            return connections.length >= n-1 ? components - 1 : -1;
        }
    }

    private static class UnionFind {
        int[] root;

        public UnionFind(int n, int[][] connections) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
            for (int[] connection : connections) {
                connect(connection[0], connection[1]);
            }
        }

        private int countComponents() {
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if(root[i] == i) {
                    count++;
                }
            }
            return count;
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        private int find(int node) {
            if (root[node] == node) {
                return node;
            }
            int found = find(root[node]);
            root[node] = found;
            return found;
        }
    }
}
