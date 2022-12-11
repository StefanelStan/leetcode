package com.ss.leetcode.LC2022.december;

import com.ss.leetcode.shared.TreeNode;

public class BinaryTreeMaximumPathSum {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum
    /** Algorithm
     *   1. Determine the left or right sub-branch max value.
     *   2. MaxPathSum is the max between max knows and maxLeft + maxRight + nodeVal
     *   3. TraverTree will return the max between (left /right) sub-branch + node Value
     */
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = {Integer.MIN_VALUE};
        traverseTree(root, maxPathSum);
        return maxPathSum[0];
    }

    private int traverseTree(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }
        int maxFromLeft = Math.max(traverseTree(node.left, maxPathSum), 0);
        int maxFromRight = Math.max(traverseTree(node.right, maxPathSum), 0);
        maxPathSum[0] = Math.max(maxPathSum[0], node.val + maxFromLeft + maxFromRight);
        return node.val + Math.max(maxFromLeft, maxFromRight);
    }
}
