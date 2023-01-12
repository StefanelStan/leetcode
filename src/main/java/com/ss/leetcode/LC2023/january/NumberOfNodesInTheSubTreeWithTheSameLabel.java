package com.ss.leetcode.LC2023.january;

import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    /** Algorithm
        1. The given edges can represent [parent,child] OR [child-parent] relation/connection.
        2. Map the connections from a node to another node in a List[n].
            EG: [2,3],[1,3],[0,3]
            [1] will contain a list of (3)
            [2] will contain a list of (3)
            [3] will contain a list of (0,1,2)
            [0] will contain a list of (3).
        3. Having this double mapping and knowing that node 0 is the root, we know that ALL the nodes of [0] are parents to other nodes (or maybe leafs).
        4. Using a boolean[visited] we can visit and mark all the nodes that descend from 0.
           Marking the visit in boolean will stop from doing a cycle 0 -> 3 and 3 -> 0 (as 0 is in the list of 3)
        5. Visiting each node: the idea is that each node will push up (post-order) and int[26] that counts the letters on its subtree.
           Each node will merge this count of each subtree with its own label.
           Now we have all the information of the subtree to push the answer[nodeVal] / label/letter count
            EG: subtree1 has 1 d: [0,0,0,1,..0]
            subtree2 has 1 b: [0,1,0,....0]
            current node is b:[0,1,0,....0]
            merging these 3 results in [0,2,0,1,..0]
            So this node of letter b has 2b -> we can add this to answer[] array
     */
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List[] tree = buildTree(n, edges);
        int[] labelCount = new int[n];
        traverseTree(0, tree, new boolean[n], labels.toCharArray(), labelCount);
        return labelCount;
    }

    // Do a double mapping: 1 -> 3 and 3 -> 1. We do not know which is the parent and which is the child node.
    private List[] buildTree(int n, int[][] edges) {
        List[] mapped = new List[n];
        for (int[] edge : edges) {
            if (mapped[edge[0]] == null) {
                mapped[edge[0]] = new ArrayList<>();
            }
            if (mapped[edge[1]] == null) {
                mapped[edge[1]] = new ArrayList<>();
            }
            mapped[edge[0]].add(edge[1]);
            mapped[edge[1]].add(edge[0]);
        }
        return mapped;
    }

    // DFS. each subtree will push its letter count in a form of int[26]
    private int[] traverseTree(int node, List[] tree, boolean[] visited, char[] labels, int[] labelCount) {
        int[] count = new int[26];
        count[labels[node] - 'a']++;
        visited[node] = true;
        if (tree[node] != null) {
            List<Integer> connections = tree[node];
            for (int connection : connections) {
                if(!visited[connection]) {
                    mergeCount(count, traverseTree(connection, tree, visited, labels, labelCount));
                }
            }
        }
        labelCount[node] = count[labels[node] - 'a'];
        return count;
    }

    private void mergeCount(int[] to, int[] from) {
        for (int i = 0; i < to.length; i++) {
            to[i] += from[i];
        }
    }
}
