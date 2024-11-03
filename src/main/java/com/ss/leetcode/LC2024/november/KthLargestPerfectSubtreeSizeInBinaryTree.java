package com.ss.leetcode.LC2024.november;

import com.ss.leetcode.shared.TreeNode;

public class KthLargestPerfectSubtreeSizeInBinaryTree {
    // https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree
    /** Algorithm
        1. Use an int[2001] to store the size count of each subtree. Use count[0] to keep track of how many valid subtrees you got.
        2. Create a recursive function that will return the number of left / right subtree node count.
            - if node is null, the count is 0.
            - if leaf, the left = 0, right = 0 + current node = 1.
            - if node is unbalanced, return -1 for this subtree
        3. Apply POST-order traversal and get the count of left and right subtree size for each node.
            - if both subtrees have diff count then it's not balanced. return -1 for current tree
            - else add their sum + 1 and set inside count[] and return this sum.
        4. If count[0] < k, you don't have enough nodes. Else, iterate from 2000 and decrement k while k > 0
     */
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        int[] perfectSubtrees = new int[2001];
        traverseTree(root, perfectSubtrees);
        if (k > perfectSubtrees[0]) {
            return -1;
        }
        int i = 2001;
        while (k > 0) {
            i--;
            if (perfectSubtrees[i] > 0) {
                k -= perfectSubtrees[i];
            }
        }
        return i;
    }

    private int traverseTree(TreeNode node, int[] perfectSubtrees) {
        if (node == null) {
            return 0;
        }
        int left = traverseTree(node.left, perfectSubtrees);
        int right = traverseTree(node.right, perfectSubtrees);
        int subtreeCount = -1;
        if (left != -1 && left == right) {
            subtreeCount = 1 + left + right;
            perfectSubtrees[0]++;
            perfectSubtrees[subtreeCount]++;
        }
        return subtreeCount;
    }
}
