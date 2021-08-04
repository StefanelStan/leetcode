package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingOrderSearchTree {
    // https://leetcode.com/problems/increasing-order-search-tree/
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traverseTree(root, nodes);
        Collections.sort(nodes);
        TreeNode newRoot = buildTree(nodes);
        return newRoot;
    }

    private void traverseTree(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            traverseTree(root.left, nodes);
            traverseTree(root.right, nodes);
        }
    }

    private TreeNode buildTree(List<Integer> nodes) {
        TreeNode root = new TreeNode(nodes.get(0));
        TreeNode current = root;
        for (int i = 1; i < nodes.size(); i++) {
            current.left = null;
            current.right = new TreeNode(nodes.get(i));
            current = current.right;
        }
        return root;
    }
}
