package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class InsertIntoABST {
    // https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        traverseAndInsert(root, val);
        return root;
    }

    private void traverseAndInsert(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                traverseAndInsert(node.left, val);
            }
        } else {
            if(node.right == null) {
                node.right = new TreeNode(val);
            } else {
                traverseAndInsert(node.right, val);
            }
        }
    }
}
