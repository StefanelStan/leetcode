package com.ss.leetcode.LC2024.march;

import com.ss.leetcode.shared.ListNode;
import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    // https://leetcode.com/problems/palindrome-linked-list
    /** Algorithm
        1. Find the middle of LL (based on length parity)
        2. From middle, reverse the 2nd half
        3. Compare the first half (in order) with the reversed 2nd half
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        int[] size = {1};
        ListNode stoppingNode = getStoppingNode(head, size);
        ListNode nodeToStartReverse = size[0] % 2 == 0 ? stoppingNode : stoppingNode.next;
        ListNode reverseHead = reverse(nodeToStartReverse);
        return areEqual(head, reverseHead, stoppingNode);
    }

    private ListNode getStoppingNode(ListNode head, int[] size) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            size[0]++;
            if (fast.next != null) {
                fast = fast.next;
                size[0]++;
            }
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private boolean areEqual(ListNode head1, ListNode head2, ListNode stoppingNode) {
        while (head1 != null && head2 != null && head1 != stoppingNode) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }


    // submitted in Sep 2021
    public boolean isPalindrome2(ListNode head) {
        List<Integer> ints = new ArrayList<>();
        while(head != null) {
            ints.add(head.val);
            head = head.next;
        }
        int low = 0, high = ints.size() -1;
        while(low < high) {
            if (ints.get(low++).intValue() != ints.get(high--)) {
                return false;
            }
        }
        return true;
    }
}
