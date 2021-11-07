package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

public class InsufficientNodesInRootToLeafPaths {
    // https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode preHead = new TreeNode(0, root, null);
        traverseTree(root, preHead, true, 0, limit);
        return preHead.left;
    }

    private int traverseTree(TreeNode node, TreeNode parent, boolean isLeft, int sum, int limit) {
        if (node.left == null && node.right == null) {
            if (sum + node.val < limit) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return node.val + sum;
        }
        sum += node.val;
        int maxVal = (node.left == null ? -1_000_000_000 : traverseTree(node.left, node, true, sum, limit));
        if (node.right != null) {
            maxVal = Math.max(maxVal, traverseTree(node.right, node, false, sum, limit));
        }
        if (maxVal < limit) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        return maxVal;
    }
}
