package com.ss.leetcode.LC2024.august;

import com.ss.leetcode.shared.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {
    // https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode originalHead = head;
        ListNode next;
        while(head.next != null) {
            next = head.next;
            head.next = new ListNode(getGCD(head.val, next.val), next);
            head = next;
        }
        return originalHead;
    }

    private int getGCD(int number1, int number2) {
        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);
        if (max % min == 0) {
            return min;
        }
        int gcd = min / 2;
        while(gcd > 1 && (max % gcd != 0 || min % gcd != 0)) {
            gcd--;
        }
        return gcd;
    }
}
