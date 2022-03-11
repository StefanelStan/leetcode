package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.ListNode;

public class RotateList {
    // https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 0;
        ListNode startNode = head;
        ListNode tail = null;
        // get Size to determine the cut
        while(head != null) {
            size++;
            tail = head;
            head = head.next;
        }
        head = startNode;
        if (k % size == 0) {
            return head;
        }
        size -= (k % size);
        while(size > 1) {
            head = head.next;
            size--;
        }
        tail.next = startNode;
        startNode = head.next;
        head.next = null;
        return startNode;
    }
}
