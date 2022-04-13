package com.ss.leetcode.LC2022.april;

import com.ss.leetcode.shared.TreeNode;

public class AddOneRowToTree {
    // https://leetcode.com/problems/add-one-row-to-tree/
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        traverseTree(root, 1, val, depth);
        return root;
    }

    public void traverseTree(TreeNode node, int currentDepth, int val, int targetDepth) {
        if (node == null) {
            return;
        }
        if (currentDepth + 1 == targetDepth) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        } else {
            traverseTree(node.left, currentDepth + 1, val, targetDepth);
            traverseTree(node.right, currentDepth + 1, val, targetDepth);
        }
    }
}
