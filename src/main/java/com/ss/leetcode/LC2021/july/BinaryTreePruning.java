package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

public class BinaryTreePruning {
    // https://leetcode.com/problems/binary-tree-pruning/
    public TreeNode pruneTree(TreeNode root) {
        hasOnesLowerLevel(root);
        return root.val == 0 && root.right == null && root.left == null ? null : root;
    }

    private boolean hasOnesLowerLevel(TreeNode node) {
        if (node.left != null && !hasOnesLowerLevel(node.left)) {
            node.left = null;
        }

        if (node.right != null && !hasOnesLowerLevel(node.right)) {
            node.right = null;
        }

        return node.val != 0 || node.left != null || node.right != null;
    }
}
