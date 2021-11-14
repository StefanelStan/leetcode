package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

public class RecoverBinarySearchTree {
    // https://leetcode.com/problems/recover-binary-search-tree/

    public void recoverTree(TreeNode root) {
        TreeNode preHead = new TreeNode(0, root, null);
        BadNode[] badNodes = new BadNode[2];
        traverseTree(preHead, root, true, badNodes);
        swapNodes(badNodes[0], badNodes[1]);
        root.val = preHead.left.val;
        root.left = preHead.left.left;
        root.right = preHead.left.right;
    }

    private void traverseTree(TreeNode preHead, TreeNode root, boolean isLeft, BadNode[] badNodes) {

    }


    private void swapNodes(BadNode badNode1, BadNode badNode2) {
        // treat the case when parent and child need to be swapped together!
        if (badNode1.node == badNode2.parent) {
            swapRelatedNodes(badNode1, badNode2);
        } else if (badNode2.node == badNode1.parent) {
            swapRelatedNodes(badNode2, badNode1);
        } else {
            swapDistinctNodes(badNode1, badNode2);
        }
    }

    private void swapRelatedNodes(BadNode upper, BadNode lower) {
        TreeNode upperClone = new TreeNode(upper.node.val);
        TreeNode lowerClone = new TreeNode(lower.node.val);

        // set LEFT and RIGHT
        upperClone.left = lower.node.left;
        upperClone.right = lower.node.right;

        if (lower.isLeft) {
            lowerClone.right = upper.node.right;
            lowerClone.left = upperClone;
        } else {
            lowerClone.left = upper.node.left;
            lowerClone.right = upperClone;
        }

        // set parent of upper
        if (upper.isLeft) {
            upper.parent.left = lowerClone;
        } else {
            upper.parent.right = lowerClone;
        }
    }

    private void swapDistinctNodes(BadNode node1, BadNode node2) {
        TreeNode node1Clone = new TreeNode(node1.node.val);
        TreeNode node2Clone = new TreeNode(node2.node.val);

        node1Clone.left = node2.node.left;
        node1Clone.right = node2.node.right;
        if (node2.isLeft) {
            node2.parent.left = node1Clone;
        } else {
            node2.parent.right = node1Clone;
        }

        node2Clone.left = node1.node.left;
        node2Clone.right = node1.node.right;
        if (node1.isLeft) {
            node1.parent.left = node2Clone;
        } else {
            node1.parent.right = node2Clone;
        }
    }

    private static class BadNode {
        TreeNode parent;
        TreeNode node;
        boolean isLeft;
    }
}
