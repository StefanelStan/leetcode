package com.ss.leetcode.LC2022.april;

import com.ss.leetcode.shared.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    // https://leetcode.com/problems/intersection-of-two-linked-lists/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLengthOf(headA);
        int bLength = getLengthOf(headB);
        if (aLength == bLength) {
            return getFirstCommonNode(headA, headB);
        }
        ListNode shortList = aLength < bLength ? headA : headB;
        ListNode longList = aLength > bLength ? headA : headB;
        ListNode trimmedList = getKthNode(longList, Math.abs(aLength - bLength));
        return getFirstCommonNode(shortList, trimmedList);
    }

    private int getLengthOf(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode getKthNode(ListNode head, int k) {
        while(k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    private ListNode getFirstCommonNode(ListNode headA, ListNode headB) {
        while(headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> headANodes = new HashSet<>();
        while(headA != null) {
            headANodes.add(headA);
            headA = headA.next;
        }
        ListNode prev = headB;
        while(headB != null) {
            if (headANodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
