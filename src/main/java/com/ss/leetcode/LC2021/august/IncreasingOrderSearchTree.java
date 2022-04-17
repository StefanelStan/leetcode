package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingOrderSearchTree {
    // https://leetcode.com/problems/increasing-order-search-tree/
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] minHeads = new TreeNode[2];
        traverseTree(root, minHeads);
        return minHeads[0];
    }

    private void traverseTree(TreeNode node, TreeNode[] minHeads) {
        if (node == null) {
            return;
        }
        if (node.left == node.right) {
            if (minHeads[0] == null) {
                minHeads[0] = node;
                minHeads[1] = node;
            } else {
                minHeads[1].right = node;
                minHeads[1] = node;
            }
            return;
        }
        traverseTree(node.left, minHeads);
        if (minHeads[0] == null) {
            minHeads[0] = node;
            minHeads[1] = node;
            node.left = null;
        } else {
            minHeads[1].right = node;
            minHeads[1] = node;
            node.left = null;
        }
        traverseTree(node.right, minHeads);
    }

    public TreeNode increasingBST2(TreeNode root) {
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
