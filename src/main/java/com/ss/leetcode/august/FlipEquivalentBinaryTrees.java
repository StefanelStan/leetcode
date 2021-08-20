package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class FlipEquivalentBinaryTrees {
    // https://leetcode.com/problems/flip-equivalent-binary-trees/
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        boolean[] isEquivalent = {true};
        if (root1 == null && root2 == null) {
            return true;
        }
        parseTrees(root1, root2, isEquivalent);
        return isEquivalent[0];
    }

    private void parseTrees(TreeNode node1, TreeNode node2, boolean[] isEquivalent) {
        if (isEquivalent[0]) {
            if (node1 == null && node2 == null) {
                return;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                isEquivalent[0] = false;
            } else if (node1.left != null && node2.left != null && node1.left.val == node2.left.val) {
                parseTrees(node1.left, node2.left, isEquivalent);
                parseTrees(node1.right, node2.right, isEquivalent);
            } else if(node1.left != null && node2.right != null && node1.left.val == node2.right.val) {
                parseTrees(node1.left, node2.right, isEquivalent);
                parseTrees(node1.right, node2.left, isEquivalent);
            } else if (node1.right != null && node2.left != null && node1.right.val == node2.left.val) {
                parseTrees(node1.right, node2.left, isEquivalent);
                parseTrees(node1.left, node2.right, isEquivalent);
            } else if(node1.right != null && node2.right != null && node1.right.val == node2.right.val) {
                parseTrees(node1.left, node2.left, isEquivalent);
                parseTrees(node1.right, node2.right, isEquivalent);
            } else if (node1.left == node1.right && node2.left == node2.right) {
                return;
            } else {
                isEquivalent[0] = false;
            }
        }
    }
}
