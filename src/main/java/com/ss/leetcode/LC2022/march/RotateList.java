package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.ListNode;

public class RotateList {
    // https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] tail = {null};
        int size = getSize(head, tail);
        if (k % size == 0) {
            return head;
        }
        ListNode targetNode = getTargetNode(head, size - (k % size));
        if (targetNode == tail[0]) {
            targetNode.next = head;
        } else {
            tail[0].next = head;
        }
        return targetNode;
    }

    private int getSize(ListNode head, ListNode[] tail) {
        int size = 0;
        while(head != null) {
            size++;
            tail[0] = head;
            head = head.next;
        }
        return size;
    }

    private ListNode getTargetNode(ListNode head, int indexPos) {
        ListNode targetNode = null;
        ListNode prev = null;
        while (head != null) {
            if (indexPos == 0) {
                targetNode = head;
                prev.next = null;
                break;
            }
            indexPos--;
            prev = head;
            head = head.next;
        }
        return targetNode;
    }

    public ListNode rotateRight2(ListNode head, int k) {
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
