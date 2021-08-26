package com.ss.leetcode.august;

import com.ss.leetcode.shared.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            tail = new ListNode(head.val, tail);
            head = head.next;
        }
        return tail;
    }
}
