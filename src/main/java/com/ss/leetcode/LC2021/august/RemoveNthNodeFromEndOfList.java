package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode countingHead = head;
        int size = 0;
        while (countingHead != null) {
            countingHead = countingHead.next;
            size++;
        }
        if (size == n) {
            head = head.next; return head;
        }
        ListNode traversingHead = head;
        for (int i = 0; i < size - n - 1; i++) {
            traversingHead = traversingHead.next;
        }
        traversingHead.next = traversingHead.next.next;
        return head;

    }
}
