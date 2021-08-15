package com.ss.leetcode.august;

import com.ss.leetcode.shared.ListNode;

public class MergeInBetweenLinkedLists {
    // https://leetcode.com/problems/merge-in-between-linked-lists/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;
        ListNode firstInsertionPoint = null;
        ListNode secondInsertionPoint = null;
        ListNode listTwoTail = getTail(list2);
        int index = 0;
        while(current != null && index < b + 1) {
            if (index == a - 1) {
                firstInsertionPoint = current;
            } else if (index == b) {
                secondInsertionPoint = current.next;
                break;
            }
            index++;
            current = current.next;
        }

        firstInsertionPoint.next = list2;
        listTwoTail.next = secondInsertionPoint;
        return list1;
    }

    private ListNode getTail(ListNode head) {
        ListNode current = head;
        while (current!= null) {
            if (current.next == null) {
                break;
            } else {
                current = current.next;
            }
        }
        return current;
    }
}
