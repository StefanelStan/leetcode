package com.ss.leetcode.LC2023.march;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    /** Algorithm
        1. Looking at the problem context, we actually need to know how many disconnected components and their size.
            EG: 3 disconnected components of size 4,1,2 will lead to 4 * 1 + 4 * 2 + 1 * 2 number of pairs.
        2. As noticed, use UnionFind to get the number and size of components
        3. Find the root of each node 1..n and increment the number of attached nodes /component size of that root.
        4. Once you have this, calculate the prefixSum of the components size
            EG: components 4,1,2 => 4,5,7.
        5. Loop from prefixSum.length -1 to 1 and calculate the number of pairs component l-1 can form
            i = 2 componentSize = 7-5 = 2. Number of nodes outside this component(prefixSum[i-1]) : 5 => 2 * 5 = 10.
            i = 1 componentSize: 5-4 = 1. Number of nodes outisde this component(prefixSum[i-1]): 4 => 1 * 4=  4.
            So total is 10 + 4.
        6. Return the total
     */
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n, edges);
        int[] components = new int[n];
        int numberOfComponents = getComponentsSize(uf, components);
        int[] prefixSum = getPrefixSum(components, numberOfComponents);
        return countPairs(prefixSum);
    }

    private int getComponentsSize(UnionFind uf, int[] components) {
        int numberOfComponents = 0;
        for (int i = 0; i < components.length; i++) {
            int root = uf.find(i);
            if (components[root]++ == 0) {
                numberOfComponents++;
            }
        }
        return numberOfComponents;
    }

    private int[] getPrefixSum(int[] components, int numberOfComponents) {
        int[] prefixSum = new int[numberOfComponents];
        int index = 0, prev = 0;
        for (int component : components) {
            if (component > 0) {
                prefixSum[index] = component + prev;
                prev = prefixSum[index];
                index++;
            }
        }
        return prefixSum;
    }

    private long countPairs(int[] prefixSum) {
        long count = 0;
        int currentGroupSize;
        for (int i = prefixSum.length -1; i > 0; i--) {
            currentGroupSize = prefixSum[i] - prefixSum[i-1];
            count += (long)currentGroupSize * (prefixSum[i-1]);
        }
        return count;
    }

    private static class UnionFind {
        private int[] root;

        public UnionFind(int n, int[][] edges) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
            for (int[] edge : edges) {
                connect(edge[0], edge[1]);
            }
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
