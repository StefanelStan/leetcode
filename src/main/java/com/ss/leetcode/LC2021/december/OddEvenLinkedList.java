package com.ss.leetcode.LC2021.december;

import com.ss.leetcode.shared.ListNode;

public class OddEvenLinkedList {
    // https://leetcode.com/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int index = 3;
        ListNode firstOddHead = head;
        ListNode firstEvenHead = head.next;
        head = head.next;
        head = head.next;
        ListNode oddHead = null;
        ListNode evenHead = null;
        while (head != null) {
            if (index % 2 == 1) {
                // odd heads
                if (oddHead == null) {
                    oddHead = head;
                    firstOddHead.next = oddHead;
                } else {
                    oddHead.next = head;
                    oddHead = head;
                }
            } else {
                // even heads
                if (evenHead == null) {
                    evenHead = head;
                    firstEvenHead.next = evenHead;
                } else {
                    evenHead.next = head;
                    evenHead = head;
                }
            }
            head = head.next;
            index++;
        }
        if (oddHead != null) {
            oddHead.next = firstEvenHead;
            if (evenHead != null) {
                evenHead.next = null;
            } else {
                firstEvenHead.next = null;
            }
        } else {
            firstEvenHead.next =  null;
        }

        return firstOddHead;
    }
}
