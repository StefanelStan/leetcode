package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

public class BinaryTreeTilt {
    // https://leetcode.com/problems/binary-tree-tilt/
    public int findTilt(TreeNode root) {
        int[] tiltSum = {0};
        if (root != null) {
            traverseTree(root, tiltSum);
        }
        return tiltSum[0];
    }

    private int traverseTree(TreeNode node, int[] tiltSum) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            leftSum = traverseTree(node.left, tiltSum);
        }
        if (node.right != null) {
            rightSum = traverseTree(node.right, tiltSum);
        }
        tiltSum[0] += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}
