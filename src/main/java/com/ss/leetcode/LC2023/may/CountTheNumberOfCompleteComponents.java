package com.ss.leetcode.LC2023.may;

public class CountTheNumberOfCompleteComponents {
    // https://leetcode.com/problems/count-the-number-of-complete-components
    /** Algorithm
        1. A complete connected component is a component that has all nodes with an indegree = component size -1.
            EG: for a component of size 6, each node need to be connected to the rest of 5, thus its indegree = 5.
        2. Apply UnionFind. When connecting nodes, also keep track of their indegree. At the end, you will verify if the
            indegree of each node == componentSize -1.
        3. After connecting the nodes, determine each component's size.
        4. Traverse the nodes and check if ALL the nodes have an indegree with componentSize -1.
            If no, then that component is not fully connected
        5. Return the number of fully connected components.
     */
    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n, edges);
        return uf.countCompleteComponents();
    }

    private static class UnionFind {
        int[] root;
        int[] indegree;

        public UnionFind(int n, int[][] edges) {
            root = new int[n];
            indegree = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
            for (int[] edge : edges) {
                connect(edge[0], edge[1]);
            }
        }

        private void connect(int node1, int node2) {
            indegree[node1]++;
            indegree[node2]++;
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        private int find(int node) {
            if(root[node] == node) {
                return node;
            }
            int found = find(root[node]);
            root[node] = found;
            return found;
        }

        public int countCompleteComponents() {
            boolean[] isCompleteComponent = new boolean[root.length];
            int[] componentSize = getComponentSizes(isCompleteComponent);
            int root1;
            for (int i = 0; i < root.length; i++) {
                root1 = find(i);
                isCompleteComponent[root1] = isCompleteComponent[root1] && indegree[i] == componentSize[root1] - 1;
            }
            int complete = 0;
            for (boolean isComplete : isCompleteComponent) {
                complete += isComplete ? 1 : 0;
            }
            return complete;
        }

        private int[] getComponentSizes(boolean[] isCompleteComponent) {
            int[] componentSize = new int[root.length];
            int nodeRoot;
            for (int i = 0; i < root.length; i++) {
                nodeRoot = find(i);
                componentSize[nodeRoot]++;
                isCompleteComponent[nodeRoot] = true;
            }
            return componentSize;
        }
    }
}
