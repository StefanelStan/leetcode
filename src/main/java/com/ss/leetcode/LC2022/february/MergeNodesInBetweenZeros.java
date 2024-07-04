package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.ListNode;

public class MergeNodesInBetweenZeros {
    // https://leetcode.com/problems/merge-nodes-in-between-zeros/
    /** Algorithm
        1. Traverse the list and add values of nodes after each zero.
        2. When you encounter a zero, insert a new node into your new list. Append the node to the tail.
        3. Return the new head.
     */
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        int sum = 0;
        ListNode newHead = null, tail = null;
        while (head != null) {
            if (head.val == 0) {
                if (sum > 0) {
                    ListNode newNode = new ListNode(sum);
                    if (newHead == null) {
                        newHead = tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                }
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return newHead;
    }


    public ListNode mergeNodes2(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode currentNewNode = null;
        int sum = 0;
        while (head != null) {
            while(head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            if (sum > 0) {
                if (preHead.next == null) {
                    preHead.next = new ListNode(sum);
                    currentNewNode = preHead.next;
                } else {
                    currentNewNode.next = new ListNode(sum);
                    currentNewNode = currentNewNode.next;
                }
                sum = 0;
            }
            head = head.next;
        }
        return preHead.next;
    }
}
