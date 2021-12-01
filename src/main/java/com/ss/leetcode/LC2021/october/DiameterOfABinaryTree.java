package com.ss.leetcode.LC2021.october;

import com.ss.leetcode.shared.TreeNode;

public class DiameterOfABinaryTree {
    // https://leetcode.com/problems/diameter-of-binary-tree/
    public int diameterOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] maxDiameter = { 0 };
        parseTree(root, maxDiameter);
        return maxDiameter[0];
    }

    private int parseTree(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }
        if (node.left == node.right) {
            return 1;
        }
        int leftMax = parseTree(node.left, maxDiameter);
        int rightMax = parseTree(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
