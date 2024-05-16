package com.ss.leetcode.LC2022.july;

import com.ss.leetcode.shared.TreeNode;

public class EvaluateBooleanBinaryTree {
    // https://leetcode.com/problems/evaluate-boolean-binary-tree/
    public boolean evaluateTree(TreeNode root) {
        return root.val <= 1 ? root.val == 1 : root.val == 2
            ? evaluateTree(root.left) || evaluateTree(root.right)
            : evaluateTree(root.left) && evaluateTree(root.right);
    }

    /** Algorithm:
         1. Fail fast: if root.left is null and root.right is null, return true of false (root.val == 1)
         2. In a DFS post-order method, if current node is leaf, return it's boolean value
         If not, get boolean value of left, or right.
         Apply the OR or AND function (2 or 3)  of left/right returned values and return the value.
     */
    public boolean evaluateTree2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        return traverseTree(root);
    }

    private boolean traverseTree(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val == 1;
        }
        boolean onLeft = traverseTree(node.left);
        boolean onRight = traverseTree(node.right);
        return node.val == 2 ? (onLeft || onRight) : (onLeft && onRight);
    }
}
