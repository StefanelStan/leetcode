package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.ListNode;

public class MiddleOfTheLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
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
