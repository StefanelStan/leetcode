package com.ss.leetcode.LC2022.june;

import com.ss.leetcode.shared.ListNode;

public class PartitionList {
    //https://leetcode.com/problems/partition-list/
    /** Algorithm
        1. Create 2 arrays[2] of pointers: one for lessThan and one for greaterOrEqual segments.
        2. Traverse the list and based on node value, add it to one of the two lists.
            Pay attention when you set the head and tail of each segment
        3. At the end, link the tail of lessThan to the head of greaterOrEqual.
        4. Return the new list.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode[] lessThan = new ListNode[2];
        ListNode[] greaterOrEqual = new ListNode[2];
        ListNode next;
        while(head != null) {
            next = head.next;
            if (head.val < x) {
                appendToList(lessThan, head);
            } else {
                appendToList(greaterOrEqual, head);
            }
            head = next;
        }
        return linkSegments(lessThan, greaterOrEqual);
    }

    private ListNode linkSegments(ListNode[] first, ListNode[] second) {
        if (first[0] == null) {
            return second[0];
        } else if (second[0] == null) {
            return first[0];
        } else {
            ListNode linkingNode = first[1] == null ? first[0] : first[1];
            linkingNode.next = second[0];
            return first[0];
        }
    }

    private void appendToList(ListNode[] list, ListNode node) {
        if (list[0] == null) {
            list[0] = node;
            list[0].next = null;
        } else {
            if (list[1] == null) {
                list[1] = node;
                list[0].next = list[1];
            } else {
                list[1].next = node;
                list[1] = node;
            }
            list[1].next = null;
        }
    }

    /** Algorithm
     *  1. Create two pointers: one for currentLess and one for greaterOrEqual.
     *  2. Traverse the list and initialize a lessHead and geHead upon encountering, depending on values
     *  3. With each step, determine what pointer you are at: currentLess, lessHead, currentGe or geHead
     *  4. Based on #3, link the previous currentLess to head (if less) or currentGe to head (if >=)
     *  5. In the end, check the bindings (as last greater might point to a less).
     */
    public ListNode partition2(ListNode head, int x) {
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
