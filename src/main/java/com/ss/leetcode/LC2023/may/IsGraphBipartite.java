package com.ss.leetcode.LC2023.may;

public class IsGraphBipartite {
    // https://leetcode.com/problems/is-graph-bipartite
    /** Algorithm
        1. What is Bipartite? It means for each edge, the left node is in partition1 and right node in partition 2
        2. Select first node and put it in partition1. The connected nodes will be put to P2.
        3. Iteratively, for each node from firstNode, put their children into partition P1.
            If it cannot be done (1 -> [2,3], 2[1,3]) so P1 = [1], P2[2,3],
            but when on node 2, (P2), node1 and 3 must be in P1, but 3 is also in 2 => cannot be made
     */
    public boolean isBipartite(int[][] graph) {
        int[] colorNodes = new int[graph.length];
        boolean[] isBipartite = {true};
        for (int i = 0; i < graph.length && isBipartite[0]; i++) {
            if (colorNodes[i] == 0) {
                traverseAndColor(graph, i, 1, colorNodes, isBipartite);
            }
        }
        return isBipartite[0];
    }

    private void traverseAndColor(int[][] graph, int node, int color, int[] colorNodes, boolean[] isBipartite) {
        if (!isBipartite[0] || colorNodes[node] == color) {
            return;
        }
        if (colorNodes[node] != 0 && colorNodes[node] != color) {
            isBipartite[0] = false;
            return;
        }
        colorNodes[node] = color;
        int nextColor = 3 - color;
        for (int connection : graph[node]) {
            traverseAndColor(graph, connection, nextColor, colorNodes, isBipartite);
        }
    }
}
