package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree {
    // https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
    // PRO MODE
    public TreeNode bstToGst(TreeNode root) {
        int sum = getBSTSum(root);
        traverseTree(root, new int[]{0}, sum);
        return root;
    }

    private void traverseTree(TreeNode node, int[] partialSum, int sum) {
        if (node != null) {
            traverseTree(node.left, partialSum, sum);
            int originalValue = node.val;
            node.val = sum - partialSum[0];
            partialSum[0] += originalValue;
            traverseTree(node.right, partialSum, sum);
        }
    }

    private int getBSTSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getBSTSum(node.left) + node.val + getBSTSum(node.right);
    }


    // INEFFICIENT
    public TreeNode bstToGst2(TreeNode root) {
        if (root == null) {
            return root;
        }
        int[] greaterSums =  new int[101];
        List<Integer> orderedValues = extractValues(root);
        Collections.sort(orderedValues);
        int sum = 0;
        for (int i = orderedValues.size() -1; i >= 0; i--) {
            sum += orderedValues.get(i);
            greaterSums[orderedValues.get(i)] = sum;
        }
        visitAndTransform(root, greaterSums);

        return root;
    }

    private List<Integer> extractValues(TreeNode node) {
        List<Integer> values =  new ArrayList<>();
        if(node.left != null) {
            values.addAll(extractValues(node.left));
        }

        if(node.right != null) {
            values.addAll(extractValues(node.right));
        }

        values.add(node.val);
        return values;
    }


    private void visitAndTransform(TreeNode root, int[] greaterSums) {
        root.val = greaterSums[root.val];
        if(root.left != null) {
            visitAndTransform(root.left, greaterSums);
        }
        if(root.right != null) {
            visitAndTransform(root.right, greaterSums);
        }
    }
}
