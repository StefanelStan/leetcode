package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.ListNode;

public class DeleteNodeInALinkedList {
    // https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
