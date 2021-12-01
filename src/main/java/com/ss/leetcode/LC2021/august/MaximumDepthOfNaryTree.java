package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.Node;

public class MaximumDepthOfNaryTree {
    // https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int[] maxDepth = new int[1];
        traverseTree(root, 1 , maxDepth);
        return maxDepth[0];
    }

    private void traverseTree(Node node, int currentLevel, int[] maxDepth) {
        if (node != null) {
            if(maxDepth[0] < currentLevel) {
                maxDepth[0] = currentLevel;
            }
            for (Node child : node.children) {
                traverseTree(child, currentLevel + 1, maxDepth);
            }
        }
    }
}
