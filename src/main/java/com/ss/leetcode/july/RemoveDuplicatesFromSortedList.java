package com.ss.leetcode.july;

import com.ss.leetcode.shared.ListNode;

public class RemoveDuplicatesFromSortedList {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while(currentNode != null) {
            if (currentNode.next != null && currentNode.val == currentNode.next.val) {
                ListNode nextNode = currentNode.next.next;
                while (nextNode != null && nextNode.val == currentNode.val) {
                    nextNode = nextNode.next;
                }
                currentNode.next = nextNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
    /**
     * class Solution {
     *     public ListNode deleteDuplicates(ListNode head) {
     *         ListNode currentNode = head;
     *         ListNode prevNode = currentNode;
     *         while(currentNode != null) {
     *             if (currentNode.next != null && currentNode.val == currentNode.next.val) {
     *                 ListNode nextNode = currentNode.next.next;
     *                 while (nextNode != null && nextNode.val == currentNode.val) {
     *                     nextNode = nextNode.next;
     *                 }
     *                 currentNode = nextNode;
     *                 prevNode.next = nextNode.next;
     *             }
     *             prevNode = currentNode;
     *             currentNode = currentNode.next;
     *         }
     *         return head;
     *     }
     * }
     */
}
