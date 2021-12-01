package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.ListNode;

public class MergeTwoSortedLists {
    // https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null)  return l1;
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 != null) {
            currentNode.next = l1;
        } else {
            currentNode.next = l2;
        }
        return head.next;
    }
}

