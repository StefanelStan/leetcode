package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        traverseInorder(root, inorder);
        return inorder;
    }

    private void traverseInorder(TreeNode node, List<Integer> inorder) {
        if(node != null) {
            traverseInorder(node.left, inorder);
            inorder.add(node.val);
            traverseInorder(node.right, inorder);
        }
    }
}

