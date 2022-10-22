package com.ss.leetcode.LC2022.october;

import com.ss.leetcode.shared.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int middle = getSize(head)/2;
        ListNode originalHead = head;
        for (int i = 0; i < middle - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return originalHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
