package com.ss.leetcode.LC2022.july;

import com.ss.leetcode.shared.ListNode;

public class ReverseLinkedListII {
    // https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
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
