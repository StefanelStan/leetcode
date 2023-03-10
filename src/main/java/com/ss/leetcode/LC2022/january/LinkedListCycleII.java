package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        boolean haveMet = false;
        // Floyd cycle detection
        // 1. Move slow slowly and fast twice as fast. Stop when they are both on same pointer.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                haveMet = true;
                break;
            }
        }
        //2. If they have met, move fast to head and move them together in the same speed: .next
        //3. They will meet again EXACTLY at the point of cycle.
        if (haveMet) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public ListNode detectCycle2(ListNode head) {
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
