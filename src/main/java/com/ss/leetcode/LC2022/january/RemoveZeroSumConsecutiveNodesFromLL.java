package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

public class RemoveZeroSumConsecutiveNodesFromLL {
    // https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    // TODO as multiple nodes (-3,-4, 1,6) can form up 0.
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode preHead = new ListNode(0, head);
        traverseList(preHead);
        return preHead.next;
    }

    private void traverseList(ListNode parent) {
        ListNode oParent = parent;
        ListNode node = parent.next;
        boolean foundDeletion = false;
        while(!foundDeletion && node != null && node.next != null) {
            if (node.val != -node.next.val) {
                parent = node;
                node = node.next;
            } else {
                parent.next = node.next.next;
                foundDeletion = true;
            }
        }
        if (foundDeletion) {
            traverseList(oParent);
        }
    }
}
