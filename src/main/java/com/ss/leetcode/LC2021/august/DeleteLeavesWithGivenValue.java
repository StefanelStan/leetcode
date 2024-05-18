package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class DeleteLeavesWithGivenValue {
    // https://leetcode.com/problems/delete-leaves-with-a-given-value/
    // PRO MODE
    /** Algorithm
        1. Use PreOrder DFS in a recursive function that takes the current node and parent node
        2. If current node is leaf and has the target value, set parent.left/right to null
            (depends on current node is left or right child)
        3. Upon current node, when left/right subtree have been processed, if current node has become leaf,
            it will get deleted as well from its parent
        4. If root itself has become a leaf with target value, return null.
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        traverseAndDelete(root, null, target);
        return root.left == root.right && root.val == target ? null : root;
    }

    private void traverseAndDelete(TreeNode node, TreeNode parent, int target) {
        if (node == null) {
            return;
        }
        traverseAndDelete(node.left, node, target);
        traverseAndDelete(node.right, node, target);
        if (node.left == node.right && node.val == target) {
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }


    public TreeNode removeLeafNodes2(TreeNode root, int target) {
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
