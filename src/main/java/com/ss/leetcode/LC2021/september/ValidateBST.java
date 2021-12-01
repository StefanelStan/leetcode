package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class ValidateBST {
    // https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        boolean[] isValid = { true };
        traverseAndCheck(root, false, new Integer[2], isValid);
        return isValid[0];
    }

    private void traverseAndCheck(TreeNode node, boolean isLeft, Integer[] minMax, boolean[] isValid) {
        if (isValid[0] && node != null) {
            if (!(greaterThan(node, node.left) && lesserThan(node, node.right))) {
                isValid[0] = false;
                return;
            }
            Integer[] leftMinMax = new Integer[2];
            Integer[] rightMinMax = new Integer[2];
            if (node.left != null) {
                traverseAndCheck(node.left, true, leftMinMax, isValid);
                if (leftMinMax[1] != null && node.val <= leftMinMax[1]) {
                    isValid[0] = false;
                    return;
                }
            }
            if (node.right != null) {
                traverseAndCheck(node.right, false, rightMinMax, isValid);
                if (rightMinMax[0] != null && node.val >= rightMinMax[0]) {
                    isValid[0] = false;
                    return;
                }
            }
            minMax[0] = getMin(node.val, getMin(leftMinMax[0], rightMinMax[0]));
            minMax[1] = getMax(node.val, getMax(leftMinMax[1], rightMinMax[1]));
        }
    }

    private boolean greaterThan(TreeNode node, TreeNode other) {
        return other == null || node.val > other.val;
    }

    private boolean lesserThan(TreeNode node, TreeNode other) {
        return other == null || node.val < other.val;
    }

    private Integer getMin(Integer min1, Integer min2) {
        if (min1 == null && min2 == null) {
            return null;
        }
        return min1 == null ? min2 : min2 == null ? min1 : Math.min(min1, min2);
    }

    private Integer getMax(Integer max1, Integer max2) {
        if (max1 == null && max2 == null) {
            return null;
        }
        return max1 == null ? max2 : max2 == null ? max1 : Math.max(max1, max2);
    }
}
