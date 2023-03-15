package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class SumRootToLeafNumbers {
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
       return traverseTree(root, 0);
    }

    private int traverseTree(TreeNode node, int number) {
        if (node != null) {
            number = number * 10 + node.val;
            if (node.left == node.right) {
                return number;
            } else {
                return traverseTree(node.left, number) + traverseTree(node.right, number);
            }
        }
        return 0;
    }

    public int sumNumbers2(TreeNode root) {
        if (root.left == root.right) {
            return root.val;
        }
        return getSum(root, new StringBuilder());
    }

    private int getSum(TreeNode node, StringBuilder stb) {
        if (node == null) {
            return 0;
        }
        // leaf
        if (node.left == node.right) {
            stb.append(node.val);
            int pathSum = Integer.parseInt(stb.toString());
            stb.deleteCharAt(stb.length() - 1);
            return pathSum;
        } else {
            stb.append(node.val);
            int leftSum = getSum(node.left, stb);
            int rightSum = getSum(node.right, stb);
            stb.deleteCharAt(stb.length() - 1);
            return leftSum + rightSum;
        }
    }
}
