package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SumOfLeftLeaves {
    // https://leetcode.com/problems/sum-of-left-leaves/
    public int sumOfLeftLeaves(TreeNode root) {
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

    public int sumOfLeftLeaves2(TreeNode root) {
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
