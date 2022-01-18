package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

public class LinkedListInBinaryTree {
    // https://leetcode.com/problems/linked-list-in-binary-tree/submissions/
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean[] isSubpath = {false};
        traverseTree(root, head, isSubpath);
        return isSubpath[0];
    }

    private void traverseTree(TreeNode node, ListNode listHead, boolean[] isSubpath) {
        if (node == null || isSubpath[0] || listHead == null) {
            return;
        }
        if (node.val == listHead.val) {
            searchIfContainsList(node, listHead, isSubpath);
        }
        if (!isSubpath[0]) {
            traverseTree(node.left, listHead, isSubpath);
            if (!isSubpath[0]) {
                traverseTree(node.right, listHead, isSubpath);
            }
        }
    }

    private void searchIfContainsList(TreeNode node, ListNode listNode, boolean[] isSubpath) {
        if (listNode == null || listNode.next == null) {
            isSubpath[0] = true;
            return;
        }

        if (node.left != null && node.left.val == listNode.next.val) {
            searchIfContainsList(node.left, listNode.next, isSubpath);
        }
        if (!isSubpath[0] && node.right != null && node.right.val == listNode.next.val) {
            searchIfContainsList(node.right, listNode.next, isSubpath);
        }
    }
}
