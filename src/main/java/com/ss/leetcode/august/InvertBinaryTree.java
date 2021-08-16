package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class InvertBinaryTree {
    // https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        parseAndInvertTree(root);
        return root;
    }

    private void parseAndInvertTree(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            parseAndInvertTree(node.left);
            parseAndInvertTree(node.right);
        }
    }
}
