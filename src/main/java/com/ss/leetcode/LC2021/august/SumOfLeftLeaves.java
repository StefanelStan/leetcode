package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SumOfLeftLeaves {
    // https://leetcode.com/problems/sum-of-left-leaves/
    /** Algorithm
        1. Create a function traverse(Node, isLeft) that takes a node and a flag isLeft
        2. If node is null, return 0
        3. If node if leaf, return according to flag (node.val for left and 0 for right)
        4. Traverse tree and return the sum of traverse(node.left, true) + traverse(node.right, false)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return traverseTree(root, false);
    }

    private int traverseTree(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == node.right) {
            return isLeft ? node.val : 0;
        }
        return traverseTree(node.left, true) + traverseTree(node.right, false);
    }


    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if(root.right != null) {
            sum+= sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public int sumOfLeftLeaves3(TreeNode root) {
        int[] sumOfLeftLeaves = new int[]{0};
        getSumOfLeftLeaves(root, root, sumOfLeftLeaves);
        return sumOfLeftLeaves[0];
    }

    private void getSumOfLeftLeaves(TreeNode currentNode, TreeNode parent, int[] sum) {
        if (currentNode != null) {
            if (currentNode.left == null && currentNode.right == null && parent.left == currentNode) {
                sum[0] += currentNode.val;
            } else {
                getSumOfLeftLeaves(currentNode.left, currentNode, sum);
                getSumOfLeftLeaves(currentNode.right, currentNode, sum);
            }
        }
    }
}
