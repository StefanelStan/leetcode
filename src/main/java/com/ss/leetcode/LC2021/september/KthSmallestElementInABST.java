package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class KthSmallestElementInABST {
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        int[] kthSmallest = new int[2];
        traverseTree(root, k, kthSmallest);
        return kthSmallest[0];
    }

    private void traverseTree(TreeNode node, int target, int[] kthSmallest) {
        if (kthSmallest[1] != target) {
            if (node.left == null && node.right == null) {
                kthSmallest[0] = node.val;
                kthSmallest[1]++;
            } else {
                if (node.left != null) {
                    traverseTree(node.left, target, kthSmallest);
                }
                if (kthSmallest[1] != target) {
                    kthSmallest[0] = node.val;
                    kthSmallest[1]++;
                    if (node.right != null) {
                        traverseTree(node.right, target, kthSmallest);
                    }
                }
            }
        }
    }
}
