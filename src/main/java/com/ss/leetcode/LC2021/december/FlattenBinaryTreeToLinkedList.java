package com.ss.leetcode.LC2021.december;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        if (root != null) {
            traverseAndSwitch(root);
        }
    }

    private TreeNode traverseAndSwitch(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
            return traverseAndSwitch(node.right);
        } else if (node.left != null) {
            TreeNode leftExtreme = traverseAndSwitch(node.left);
            TreeNode currentRight = node.right;
            node.right = node.left;
            node.left = null;
            leftExtreme.left = null;
            leftExtreme.right = currentRight;
            return traverseAndSwitch(currentRight);
        }
        return traverseAndSwitch(node.right);
    }

    // slower
    public void flatten2(TreeNode root) {
        if (root != null) {
            List<TreeNode> nodes = new ArrayList<>();
            traverseTree(root, nodes);
            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).right = nodes.get(i + 1);
                nodes.get(i).left = null;
            }
        }
    }

    private void traverseTree(TreeNode node, List<TreeNode> nodes) {
        if (node != null) {
            nodes.add(node);
            traverseTree(node.left, nodes);
            traverseTree(node.right, nodes);
        }
    }
}
