package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
