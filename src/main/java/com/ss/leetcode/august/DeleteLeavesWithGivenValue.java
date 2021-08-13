package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class DeleteLeavesWithGivenValue {
    // https://leetcode.com/problems/delete-leaves-with-a-given-value/
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode myRoot = new TreeNode(1, root, null);
        needsTrimming(root, myRoot, true, target);
        return myRoot.left;
    }

    private boolean needsTrimming(TreeNode node, TreeNode parent, boolean isLeft, int target) {
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return true;
            } else {
                return false;
            }
        } else if (node.right == null) {
            if (needsTrimming(node.left, node, true, target)) {
                if (node.val == target) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if (node.left == null) {
            if (needsTrimming(node.right, node, false, target)) {
                if (node.val == target) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            boolean left = needsTrimming(node.left, node, true, target);
            boolean right = needsTrimming(node.right, node, false, target);
            if(left && right) {
                if (node.val == target) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
