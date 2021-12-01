package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplittedBT {
    // https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
    public int maxProduct(TreeNode root) {
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
