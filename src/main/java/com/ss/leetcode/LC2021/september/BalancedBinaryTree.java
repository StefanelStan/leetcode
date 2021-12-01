package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class BalancedBinaryTree {
    // https://leetcode.com/problems/balanced-binary-tree/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == root.right) {
            return true;
        }
        boolean[] isBalanced = { true };
        parseTree(root, isBalanced);
        return isBalanced[0];
    }

    private int parseTree(TreeNode node, boolean[] isBalanced) {
        if (isBalanced[0]) {
            if (node == null) {
                return 0;
            }
            if (node.left == node.right) {
                return 1;
            }

            int leftMax = parseTree(node.left, isBalanced);
            int rightMax = parseTree(node.right, isBalanced);
            if (Math.abs(leftMax - rightMax) > 1) {
                isBalanced[0] = false;
                return -1;
            }
            return 1 + Math.max(leftMax, rightMax);
        }
        return 0;
    }
}
