package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class UnivaluedBinaryTree {
    // https://leetcode.com/problems/univalued-binary-tree/
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean[] isUnivalTree = {true};
        traverseTree(root, root.val, isUnivalTree);
        return isUnivalTree[0];
    }

    public void traverseTree(TreeNode node, int passedValue, boolean[] isUnivalTree) {
        if (node != null && isUnivalTree[0]) {
            if (node.val != passedValue) {
                isUnivalTree[0] = false;
            } else {
                traverseTree(node.left, passedValue, isUnivalTree);
                traverseTree(node.right, passedValue, isUnivalTree);
            }
        }
    }
}
