package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

public class MaximumDepthOfBinaryTree {
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
