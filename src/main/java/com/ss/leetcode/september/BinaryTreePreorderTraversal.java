package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    // https://leetcode.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverseTree(root, traversal);
        return traversal;
    }

    private void traverseTree(TreeNode node, List<Integer> traversal) {
        if (node != null) {
            traversal.add(node.val);
            traverseTree(node.left, traversal);
            traverseTree(node.right, traversal);
        }
    }
}
