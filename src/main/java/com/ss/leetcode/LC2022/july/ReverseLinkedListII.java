package com.ss.leetcode.LC2022.july;

import com.ss.leetcode.shared.ListNode;

public class ReverseLinkedListII {
    // https://leetcode.com/problems/reverse-linked-list-ii/
    // PRO MODE
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        if (left == 1) {
            return reverseListUntil(head, left, right);
        } else {
            ListNode originalHead = head;
            for (int i = 1; i < left - 1; i++) {
                head = head.next;
            }
            head.next = reverseListUntil(head.next, left, right);
            return originalHead;
        }
    }

    private ListNode reverseListUntil(ListNode head, int left, int right) {
        ListNode next = null, prev = null, originalHead = head;
        while (left <= right) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            left++;
        }
        originalHead.next = next;
        return prev;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode startHead = head;
        ListNode prev = head;
        int index = 1;
        while(index < left) {
            prev = head;
            head = head.next;
            index++;
        }
        ListNode reversed = reverseList(head, right - left);
        if (left > 1) {
            prev.next = reversed;
        } else {
            startHead = reversed;
        }
        return startHead;
    }

    private ListNode reverseList(ListNode head, int steps) {
        ListNode originalHead = head;
        ListNode next = null;
        ListNode previous = null;
        while (steps >= 0) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
            steps--;
        }
        originalHead.next = next;
        return previous;
    }
}
