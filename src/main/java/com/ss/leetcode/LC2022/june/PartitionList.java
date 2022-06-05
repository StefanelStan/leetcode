package com.ss.leetcode.LC2022.june;

import com.ss.leetcode.shared.ListNode;

public class PartitionList {
    //https://leetcode.com/problems/partition-list/
    /** Algorithm
     *  1. Create two pointers: one for currentLess and one for greaterOrEqual.
     *  2. Traverse the list and initialize a lessHead and geHead upon encountering, depending on values
     *  3. With each step, determine what pointer you are at: currentLess, lessHead, currentGe or geHead
     *  4. Based on #3, link the previous currentLess to head (if less) or currentGe to head (if >=)
     *  5. In the end, check the bindings (as last greater might point to a less).
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null, currentLess = null, geHead = null, currentGe = null;
        while (head != null) {
            if (head.val < x) {
                if (lessHead == null) {
                    lessHead = head;
                } else if (currentLess == null) {
                    currentLess = head;
                    lessHead.next = currentLess;
                } else {
                    currentLess.next = head;
                    currentLess = head;
                }
            } else {
                if (geHead == null) {
                    geHead = head;
                } else if (currentGe == null) {
                    currentGe = head;
                    geHead.next = currentGe;
                } else {
                    currentGe.next = head;
                    currentGe = head;
                }
            }
            head = head.next;
        }
        if (currentGe != null) {
            currentGe.next = null;
        }
        if (geHead != null && geHead.next != null && geHead.next.val < x) {
            geHead.next = null;
        }
        if (currentLess != null) {
            currentLess.next = geHead;
            return lessHead;
        } else if (lessHead != null) {
            if (lessHead.next == null) {
                lessHead.next = geHead;
            } else if (lessHead.next.val >= x) {
                lessHead.next = geHead;
            }
            return lessHead;
        } else {
            return geHead;
        }
    }
}
