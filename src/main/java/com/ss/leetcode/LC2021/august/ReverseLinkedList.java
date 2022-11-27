package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            tail = new ListNode(head.val, tail);
            head = head.next;
        }
        return tail;
    }
}
