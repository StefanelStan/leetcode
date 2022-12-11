package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplittedBT {
    // https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
    public int maxProduct(TreeNode root) {
        long[] maxProduct = {0};
        int sum = getSum(root);
        traverseTree(root, sum, maxProduct);
        return (int)(maxProduct[0] % 1_000_000_007);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private int traverseTree(TreeNode node, int sum, long[] maxProduct) {
        if (node == null) {
            return 0;
        }
        int subTreeSum = traverseTree(node.left, sum, maxProduct);
        subTreeSum += traverseTree(node.right, sum, maxProduct);
        subTreeSum += node.val;
        maxProduct[0] = Math.max(maxProduct[0], (long)subTreeSum * (sum - subTreeSum));
        return subTreeSum;
    }

    public int maxProduct2(TreeNode root) {
        List<Integer> subtreeSum = new ArrayList<>();
        traverseAndCalculateSubtreeSum(root, subtreeSum);
        return getMaxProduct(subtreeSum);
    }

    private int traverseAndCalculateSubtreeSum(TreeNode node, List<Integer> subtreeSum) {
        if (node.left == null && node.right == null) {
            subtreeSum.add(node.val);
            return node.val;
        } else {
            int sum = node.val;
            if (node.left != null) {
                sum += traverseAndCalculateSubtreeSum(node.left, subtreeSum);
            }
            if (node.right != null) {
                sum += traverseAndCalculateSubtreeSum(node.right, subtreeSum);
            }
            subtreeSum.add(sum);
            return sum;
        }
    }

    private int getMaxProduct(List<Integer> subtreeSum) {
        int modulo = 1_000_000_007;
        int totalSum = subtreeSum.get(subtreeSum.size() -1);
        long maxProduct = 0;
        for (int subsum : subtreeSum) {
            maxProduct = Math.max(maxProduct, (((long) totalSum - subsum) * subsum));
        }
        return (int) (maxProduct % modulo);
    }
}
