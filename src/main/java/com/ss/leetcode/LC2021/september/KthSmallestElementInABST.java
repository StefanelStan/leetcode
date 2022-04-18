package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class KthSmallestElementInABST {
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        int[] kSmallest = {0};
        traverseTree(root, count, kSmallest, k);
        return kSmallest[0];
    }

    private void traverseTree(TreeNode node, int[] count, int[] kSmallest, int k) {
        if (node == null || count[0] == k) {
            return;
        }
        traverseTree(node.left, count, kSmallest, k);
        // do not traverse anymore if already found the node.
        if (count[0] != k) {
            count[0]++;
            if (count[0] == k) {
                kSmallest[0] = node.val;
                return;
            }
            traverseTree(node.right, count, kSmallest, k);
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        int[] kthSmallest = new int[2];
        traverseTree2(root, k, kthSmallest);
        return kthSmallest[0];
    }

    private void traverseTree2(TreeNode node, int target, int[] kthSmallest) {
        if (kthSmallest[1] != target) {
            if (node.left == null && node.right == null) {
                kthSmallest[0] = node.val;
                kthSmallest[1]++;
            } else {
                if (node.left != null) {
                    traverseTree2(node.left, target, kthSmallest);
                }
                if (kthSmallest[1] != target) {
                    kthSmallest[0] = node.val;
                    kthSmallest[1]++;
                    if (node.right != null) {
                        traverseTree2(node.right, target, kthSmallest);
                    }
                }
            }
        }
    }
}
