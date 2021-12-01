package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class CountGoodNodesInBinaryTree {
    // https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        traverseTree(root, root.val, count);
        return count[0];
    }

    private void traverseTree(TreeNode node, int maxOnPath, int[] count) {
        if (node != null) {
            if (node.val >= maxOnPath) {
                count[0]++;
            }
            traverseTree(node.left, Math.max(maxOnPath, node.val), count);
            traverseTree(node.right, Math.max(maxOnPath, node.val), count);
        }
    }
}
