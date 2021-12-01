package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.ListNode;

public class LinkedListCycle {
    // https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 100_001) {
                return true;
            } else {
                head.val = 100_001;
            }
            head = head.next;
        }
        return false;
    }
}
