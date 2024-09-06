package com.ss.leetcode.LC2024.september;

import com.ss.leetcode.shared.ListNode;

public class DeleteNodesFromLinkedListPresentInArray {
    /** Algorithm
        1. Use a boolean[100_001] to mark the present numbers of nums
        2. Traverse head and use 3 pointers: newHead, previous and next. previous will keep a pointer to last good node (not in the list)
        3. If current node is NOT in the list then
            - if newHead is null, assign current node to newHead and previous.
            - else link previous node to current node
        4. At the end, link previous node to null, so it won't be linked to bad nodes.
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] present = new boolean[100_001];
        for (int num : nums) {
            present[num] = true;
        }

        ListNode newHead = null, previous = null, next;
        while (head != null) {
            next = head.next;
            if (!present[head.val]) { // set newHead or link prev node to current one
                if (newHead == null) {
                    newHead = previous = head;
                } else {
                    previous.next = head;
                    previous = head;
                }
            }
            head = next;
        }
        previous.next = null;
        return newHead;
    }
}
