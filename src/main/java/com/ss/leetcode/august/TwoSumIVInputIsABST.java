package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST {
    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numbers = new ArrayList<>();
        parseTreeAndStoreNumbers(root, numbers);
        return checkForSum(numbers, k);
    }

    private void parseTreeAndStoreNumbers(TreeNode node, List<Integer> numbers) {
        if (node != null) {
            parseTreeAndStoreNumbers(node.left, numbers);
            numbers.add(node.val);
            parseTreeAndStoreNumbers(node.right, numbers);
        }
    }

    private boolean checkForSum(List<Integer> numbers, int k) {
        int left = 0, right = numbers.size() -1;
        int tempSum = 0;
        while (left < right) {
            tempSum = numbers.get(left) + numbers.get(right);
            if (tempSum < k) {
                left++;
            } else if (tempSum > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        boolean[] found = {false};
        findTarget(root, root, k, found);
        return found[0];
    }

    // Algorithm:
    // 1. For each Node in Tree, try to find the target - node.val (difference) value in the entire Tree.
    // 2. As the difference could be on the other side of tree, we need to always pass the tree root as reference for BST.
    private void findTarget(TreeNode currentNode, TreeNode treeRoot, int target, boolean[] found) {
        // traverse Each subTree and for each node pass the root to search
        if(!found[0] && currentNode!= null) {
            int difference = target - currentNode.val;
            // EDGE CASES: if current node = target /2, you won't find two nodes with same value (eg: target = 4, currNode = 2. You won't find another 2)
            if (currentNode.val != difference && treeHasValue(treeRoot, difference)) {
                found[0] = true;
            }
            // if the difference (target - node.val) was not found, proceed looking for other pair candidates in the tree  (left and right)
            if (!found[0]) {
                findTarget(currentNode.left, treeRoot, target, found);
            }
            if (!found[0]) {
                findTarget(currentNode.right, treeRoot, target, found);
            }
        }
    }

    // basic binary search tree algorithm.
    private boolean treeHasValue(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        } else if (root.val < target) {
            return treeHasValue(root.right, target);
        } else {
            return treeHasValue(root.left, target);
        }
    }
}
