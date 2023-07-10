package com.ss.leetcode.LC2023.july;

import com.ss.leetcode.shared.TreeNode;

public class MinimumDepthOfBinaryTree {
    // https://leetcode.com/problems/minimum-depth-of-binary-tree
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return 1;
        }
        int minD = 100_001;
        if (root.left != null) {
            minD = Math.min(minD, minDepth(root.left));
        }
        if (root.right != null) {
            minD = Math.min(minD, minDepth(root.right));
        }
        return 1 + minD;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] minDepth = {Integer.MAX_VALUE};
        parseTree(root, 1, minDepth);
        return minDepth[0];
    }

    private void parseTree(TreeNode node, int level, int[] minDepth) {
        if (node.left == null && node.right == null) {
            minDepth[0] = Math.min(level, minDepth[0]);
        }
        if (node.left != null) {
            parseTree(node.left, level + 1, minDepth);
        }
        if (node.right != null) {
            parseTree(node.right, level + 1, minDepth);
        }
    }
}
