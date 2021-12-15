package com.ss.leetcode.LC2021.december;

import com.ss.leetcode.shared.ListNode;

public class InsertionSortList {
    // https://leetcode.com/problems/insertion-sort-list/
    public ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(-5001);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            addToSortedList(head, preHead);
            head = nextNode;
        }
        return preHead.next;
    }

    private void addToSortedList(ListNode nodeToAdd, ListNode preHead) {
        if (preHead.next == null) {
            preHead.next = nodeToAdd;
            nodeToAdd.next = null;
        } else {
            while (preHead.next != null) {
                if (preHead.next.val >= nodeToAdd.val) {
                    ListNode nextNode = preHead.next;
                    preHead.next = nodeToAdd;
                    nodeToAdd.next = nextNode;
                    return;
                } else {
                    preHead = preHead.next;
                }
            }
            preHead.next = nodeToAdd;
            nodeToAdd.next = null;
        }
    }
}
