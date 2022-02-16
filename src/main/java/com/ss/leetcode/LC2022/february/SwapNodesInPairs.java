package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.ListNode;

public class SwapNodesInPairs {
    // https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode third, second, prev =null;
        ListNode newHead = head.next;
        while(head != null && head.next != null) {
            third = head.next.next;
            second = head.next;
            head.next = third;
            second.next = head;
            if (prev != null) {
                prev.next = second;
            }
            prev = head;
            head = third;
        }
        return newHead;
    }
}
