package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteNodeInABST {
    // https://leetcode.com/problems/delete-node-in-a-bst/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == root.right && root.val != key)) {
            return root;
        }
        TreeNode preHead = new TreeNode(0, root, null);
        TreeNode[] affectedNodes = new TreeNode[] { root, null, null };
        if (root.val == key) {
            affectedNodes = new TreeNode[] { preHead, root, null };
        } else {
            findNode(root, key, affectedNodes);
        }
        TreeNode nodeToDelete = affectedNodes[1] == null ? affectedNodes[2] : affectedNodes[1];
        if (nodeToDelete == null) {
            return root;
        }
        if (nodeToDelete.left == nodeToDelete.right) {
            // leaf
            if (affectedNodes[1] == null) {
                affectedNodes[0].right = null;
            } else {
                affectedNodes[0].left = null;
            }
            return preHead.left;
        }
        List<Integer> leftOrder = new ArrayList<>();
        List<Integer> rightOrder = new ArrayList<>();
        listPreorder(nodeToDelete.left, leftOrder);
        listPreorder(nodeToDelete.right, rightOrder);
        leftOrder.addAll(rightOrder);
        Collections.sort(leftOrder);

        TreeNode newNode = new TreeNode(leftOrder.get(leftOrder.size() / 2));
        newNode.left = constructTree(leftOrder, 0, leftOrder.size() / 2 - 1);
        newNode.right = constructTree(leftOrder, leftOrder.size() / 2 + 1, leftOrder.size() - 1);
        if (affectedNodes[1] == null) {
            affectedNodes[0].right = newNode;
        } else {
            affectedNodes[0].left = newNode;
        }
        return preHead.left;
    }

    private void findNode(TreeNode node, int key, TreeNode[] affectedNodes) {
        if (node != null && affectedNodes[1] == affectedNodes[2]) {
            if (node.val == key) {
                if (affectedNodes[0].left == node) {
                    affectedNodes[1] = node;
                    affectedNodes[2] = null;
                } else {
                    affectedNodes[1] = null;
                    affectedNodes[2] = node;
                }
            } else {
                affectedNodes[0] = node;
                findNode(node.left, key, affectedNodes);
                if (affectedNodes[1] == affectedNodes[2]) {
                    affectedNodes[0] = node;
                    findNode(node.right, key, affectedNodes);
                }
            }
        }
    }

    private void listPreorder(TreeNode node, List<Integer> order) {
        if (node != null) {
            order.add(node.val);
            listPreorder(node.left, order);
            listPreorder(node.right, order);
        }
    }

    private TreeNode constructTree(List<Integer> preorder, int begin, int end) {
        if (begin == end) {
            return new TreeNode(preorder.get(begin));
        } else if (begin > end) {
            return null;
        }
        TreeNode middle = new TreeNode(preorder.get(begin + (end - begin) / 2));
        middle.left = constructTree(preorder, begin, begin + (end - begin) / 2 - 1);
        middle.right = constructTree(preorder, begin + (end - begin) / 2 + 1, end);
        return middle;
    }
}
