package com.ss.leetcode.september;

import com.ss.leetcode.shared.ListNode;

public class RemoveLinkedListElements {
    // https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        ListNode goodNode = null;

        while(head != null) {
            if (head.val != val) {
                if(goodNode == null) {
                    goodNode = head;
                    preHead.next = goodNode;
                } else {
                    goodNode.next = head;
                    goodNode = goodNode.next;
                }
            }
            head = head.next;
        }
        if (goodNode != null && goodNode.next != null && goodNode.next.val == val) {
            goodNode.next = null;
        }
        return preHead.next;
    }
}
