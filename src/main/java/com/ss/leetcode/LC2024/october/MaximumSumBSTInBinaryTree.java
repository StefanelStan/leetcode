package com.ss.leetcode.LC2024.october;

import com.ss.leetcode.shared.TreeNode;

public class MaximumSumBSTInBinaryTree {
    // https://leetcode.com/problems/maximum-sum-bst-in-binary-tree
    /** Algorithm
        1. Use a BSTNode class helper that will capture the min, max and sum of each subtree
        2. Use a recursive function traverseTree in POST-ORDER traversal that will return such data/report for both its subtrees
        3. For each call,
            - if left node is NOT null, fetch left subtree BSTNode. If BSTNode is NOT null and its max < currentNode.val,
                set new min and add its sum. (left.sum + node.val)
            - else (left.max >= node.val, then current node cannot form a BST with left. Maybe right subtree can form a BST)
            - apply same logic for right. (set new max for right)
        4. Based on left and right BSTNode reports, return either null, either a BSTNode that has the sum of left and right and min/max.
     */
    public int maxSumBST(TreeNode root) {
        int[] max = {0};
        traverseTree(root, max);
        return max[0];
    }

    private BSTNode traverseTree(TreeNode node, int[] max) {
        if (node.left == node.right) {
            max[0] = Math.max(max[0], node.val);
            return new BSTNode(node.val, node.val, node.val);
        }
        BSTNode toReturn = new BSTNode(node.val, node.val, node.val);
        BSTNode left = null, right = null;
        if (node.left != null) {
            left = traverseTree(node.left, max);
            if (left == null || node.val <= left.max) {
                left = null;
            } else {
                toReturn.min = left.min;
                toReturn.sum += left.sum;
            }
        }
        if (node.right != null) {
            right = traverseTree(node.right, max);
            if (right == null || node.val >= right.min) {
                right = null;
            } else {
                toReturn.max = right.max;
                toReturn.sum += right.sum;
            }
        }
        if ((node.left != null && left == null) || (node.right != null && right == null)) {
            return null;
        } else {
            max[0] = Math.max(max[0], toReturn.sum);
            return toReturn;
        }
    }

    private static class BSTNode {
        int min;
        int max;
        int sum;
        public BSTNode(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
}
