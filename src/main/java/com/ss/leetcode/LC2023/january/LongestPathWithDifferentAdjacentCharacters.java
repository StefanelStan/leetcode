package com.ss.leetcode.LC2023.january;

import java.util.ArrayList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {
    /** Algorithm
         1. Main idea is to apply DFS and each node/subtree will push up (to its parent)
            the max path it can build with one of its children.
            At the same time, this node can be part of a path between its children.
         2. Build the tree of nodes. For simplicity I used a List[n] while List[i] will hold a list of its children
         3. Starting from a node (root), get the length of child_0..child_n of that node.
            If child_x label is != node's label, that child/subtree is valid and its length should be considered.
         4. Get the valid length of all valid children of a node and retain just the longest 2.
            The longest 2 can make a path child_1 - node - child2. Compare this against the longest path known so far
         5. The recursive method of 4 will push up (return to the parent) the longest valid path that any of its children has + 1 (the node itself).
         6. The result of 5 can will recursively be used by the parent to either build a path child1-parent-child2 or to return it to its own parent.
     */
    public int longestPath(int[] parent, String s) {
        List[] tree = buildTree(parent);
        int[] longestPath = {1};
        traverseTree(0, tree, longestPath, s.toCharArray());
        return longestPath[0];
    }

    private List[] buildTree(int[] parent) {
        List[] tree = new List[parent.length];
        for (int i = 1; i < parent.length; i++) {
            if (tree[parent[i]] == null) {
                tree[parent[i]] = new ArrayList<>();
            }
            tree[parent[i]].add(i);
        }
        return tree;
    }

    private int traverseTree(int node, List[] tree, int[] longestPath, char[] labels) {
        if (tree[node] == null) {
            return 1;
        }
        int childLength;
        // we only need the longest 2 valid paths from the children to detect a path child1-parent-child2
        int[] lengths = {0,0};
        if (tree[node] != null) {
            List<Integer> children = tree[node];
            for (int child : children) {
                childLength = traverseTree(child, tree, longestPath, labels);
                // A child length can be taken into consideration only if its label != parent label
                if (labels[child] != labels[node]) {
                    insertLengths(childLength, lengths);
                }
            }
        }
        // longest path can be made between child_a-node-child_b
        longestPath[0] = Math.max(longestPath[0], lengths[0] + 1 + lengths[1]);
        // return the length of the longest child path/longest subtree.
        return 1 + lengths[1];
    }

    private void insertLengths(int newLength, int[] lengths) {
        if (newLength >= lengths[1]) {
            lengths[0] = lengths[1];
            lengths[1] = newLength;
        } else if (newLength > lengths[0]) {
            lengths[0] = newLength;
        }
    }
}
