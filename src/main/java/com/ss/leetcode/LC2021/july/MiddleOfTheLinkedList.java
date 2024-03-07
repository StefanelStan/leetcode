package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.ListNode;

public class MiddleOfTheLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/
    // SLOW & FAST POINTER
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public ListNode middleNode2(ListNode head) {
        int listSize = 0;
        ListNode currentNode = head;
        while(currentNode != null) {
            listSize++;
            currentNode = currentNode.next;
        }

        int index = 0;
        currentNode = head;
        while (index < listSize /2) {
            currentNode = currentNode.next;
            index++;
        }
        return currentNode;
    }
}
