package com.ss.leetcode.LC2023.may;

import com.ss.leetcode.shared.TreeNode;

public class LongestUnivaluePath {
    // https://leetcode.com/problems/longest-univalue-path
    /** Algorithm
        1. Traverse PostOder: Each parent node will try to get left/right child longest chain.
        2. Child node:
            - if node is null, return 0
            - if node is leaf return 1
        2. Parent will assess if its value is equal to right and left.
            - If all 3 match, then the parent is a chain in a path that starts from left, goes through parent and travels to right.
                However, as a chain can also come from above, return 1 + Max (left, right) chain.
            - If there is only a left or right match, then a chain/path only through that side only.
                The parent will return that side's length + 1
            - If none matches, then return 1, as the only chain that can be made is just parent.
     */
    public int longestUnivaluePath(TreeNode root) {
        int[] longestPath = {0};
        traverseTree(root, longestPath);
        return Math.max(0, longestPath[0] - 1);
    }

    private int traverseTree(TreeNode node, int[] longestPath) {
        if (node == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (node.left != null) {
            left = traverseTree(node.left, longestPath);
            if (node.left.val != node.val) {
                left = 0;
            }
        }
        if (node.right != null) {
            right = traverseTree(node.right, longestPath);
            if (node.right.val != node.val) {
                right = 0;
            }
        }
        longestPath[0] = Math.max(longestPath[0], 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
