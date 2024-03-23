package com.ss.leetcode.LC2021.december;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    // https://leetcode.com/problems/reorder-list
    /** Algorithm
        1. Return if list has just 1 node
        2. You need to find the middle of the list. Once found, reverse that second half of list
            - So L1->L2->L3->L4->L5->L6 becomes L1->L2->L3 / L6->L5->L4
        3. Now you have 2 virtual lists that can be traversed in order and re-linked.
        4. Traverse with 2 heads (head1 for list1 and head2 for list2)
            - Link head1 to head2 and head2 to head1.next (basically insert head2 between head1 and head1.next)
            - Advance both heads
            - At the end, point head1 to null (end of list)
     */
    public void reorderList(ListNode head) {
        if (head.next != null) {
            reorderEntireList(head);
        }
    }

    private void reorderEntireList(ListNode head) {
        ListNode secondListHead = getSecondListHead(head);
        ListNode nextHead, nextSecondList;
        while (secondListHead != null) {
            nextHead = head.next;
            nextSecondList = secondListHead.next;
            head.next = secondListHead;
            secondListHead.next = nextHead;
            head = nextHead;
            secondListHead = nextSecondList;
        }
        head.next = null;
    }

    private ListNode getSecondListHead(ListNode head) {
        ListNode middle = getMiddle(head);
        return reverseList(middle);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        int size = 1;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            size++;
            if (fast.next != null) {
                fast = fast.next;
                size++;
            }
        }
        return size % 2 == 0 ? slow : slow.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void reorderList2(ListNode head) {
        if (head.next == null) {
            return;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        nodeList.get(0).next = nodeList.get(size - 1);
        for (int i = 1, j = size -2; i < j; i++, j--) {
            nodeList.get(j + 1).next = nodeList.get(i);
            nodeList.get(i).next = nodeList.get(j);
            nodeList.get(j).next = null;
        }
        if (size % 2 != 0) {
            nodeList.get(size /2 + 1).next = nodeList.get(size /2);
            nodeList.get(size /2).next = null;
        }
    }
}
