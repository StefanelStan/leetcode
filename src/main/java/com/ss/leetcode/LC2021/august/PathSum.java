package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class PathSum {
    // https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean[] hasPath = new boolean[1];
        hasPath(root, targetSum, 0, hasPath);
        return hasPath[0];
    }

    private void hasPath(TreeNode node, int targetSum, int currentSum, boolean[] hasPath) {
        if(!hasPath[0] && node != null) {
            currentSum += node.val;
            if (currentSum == targetSum && node.left == null && node.right == null) {
                hasPath[0] = true;
            } else {
                hasPath(node.left, targetSum, currentSum, hasPath);
                hasPath(node.right, targetSum, currentSum, hasPath);
            }
        }
    }
}
