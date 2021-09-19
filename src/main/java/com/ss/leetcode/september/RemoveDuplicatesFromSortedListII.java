package com.ss.leetcode.september;

import com.ss.leetcode.shared.ListNode;

public class RemoveDuplicatesFromSortedListII {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode before = preHead;
        ListNode current = head;
        while (current != null){
            if (current.next != null && current.val == current.next.val) {
                ListNode nextGood = getNextGood(current.next, current.val);
                before.next = nextGood;
                current = nextGood;
            } else {
                before.next = current;
                before = current;
                current = current.next;
            }
        }
        return preHead.next;
    }

    private ListNode getNextGood(ListNode next, int val) {
        while (next != null) {
            if (next.next != null && next.next.val != val) {
                return next.next;
            } else {
                next = next.next;
            }
        }
        return null;
    }
}
