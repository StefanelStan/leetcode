package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class ValidateBST {
    // https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        if (root.left == root.right) {
            return true;
        }
        boolean[] isValid = {true};
        traverseTree(root, isValid);
        return isValid[0];
    }

    private int[] traverseTree(TreeNode node, boolean[] isValid) {
        if (node == null || !isValid[0]) {
            return null;
        }
        if (node.left == node.right) {
            return new int[]{node.val, node.val};
        }
        int[] answer = new int[]{node.val, node.val};
        int[] left = traverseTree(node.left, isValid);
        if (isValid[0] && left != null) {
            if (node.val <= left[1]) {
                isValid[0] = false;
                return new int[]{-1, -1};
            } else {
                answer[0] = Math.min(left[0], node.val);
                answer[1] = Math.max(left[1], node.val);
            }
        }
        int[] right = traverseTree(node.right, isValid);
        if (isValid[0] && right != null) {
            if (node.val >= right[0]) {
                isValid[0] = false;
                return new int[]{-1, -1};
            } else {
                answer[0] = Math.min(answer[0], Math.min(right[0], node.val));
                answer[1] = Math.max(answer[1], Math.max(right[1], node.val));
            }
        }
        return answer;
    }

    public boolean isValidBST2(TreeNode root) {
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
