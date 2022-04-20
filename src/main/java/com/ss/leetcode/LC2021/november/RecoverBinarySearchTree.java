package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

public class RecoverBinarySearchTree {

    // https://leetcode.com/problems/recover-binary-search-tree/
    // Still not working!
    public void recoverTree(TreeNode root) {
        TreeNode[][] nodes = new TreeNode[2][2];
        int[] line = {0};
        traverseTree(root, nodes, line);
        swapNodes(nodes, line);
    }

    private void traverseTree(TreeNode node, TreeNode[][] nodes, int[] line) {
        if (node == null || line[0] == 2) {
            return;
        }
        if (node.left != null && node.val < node.left.val) {
            nodes[line[0]][0] = node;
            nodes[line[0]][1] = node.left;
            line[0]++;
            if (line[0] == 2) {
                return;
            }
        }
        if (node.right != null && node.val > node.right.val) {
            nodes[line[0]][0] = node;
            nodes[line[0]][1] = node.right;
            line[0]++;
            if (line[0] == 2) {
                return;
            }
        }
        traverseTree(node.left, nodes, line);
        if (line[0] < 2) {
            nodes[line[0]][0] = nodes[line[0]][1];
            nodes[line[0]][1] = node;
            if (nodes[line[0]][0] != null && nodes[line[0]][0].val > nodes[line[0]][1].val) {
                line[0]++;
            } else {
                traverseTree(node.right, nodes, line);
            }
        }
    }

    private void swapNodes(TreeNode[][] nodes, int[] line) {
        if (line[0] == 1) {
            swapTwoNodes(nodes[0][0], nodes[0][1]);
        } else {
            if (nodes[0][0] == nodes[1][0]);
        }
    }

    private void swapTwoNodes(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
