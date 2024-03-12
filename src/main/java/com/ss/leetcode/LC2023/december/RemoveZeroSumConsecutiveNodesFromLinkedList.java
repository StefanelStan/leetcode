package com.ss.leetcode.LC2023.december;

import com.ss.leetcode.shared.ListNode;
import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    // https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }
        Map<Integer, ListNode> prefixSum = new HashMap<>();
        int sum = 0;
        ListNode originalHead = head, intervalNode;
        while (head != null) {
            if (sum + head.val == 0) {
                return removeZeroSumSublists(head.next);
            }
            sum += head.val;
            intervalNode = prefixSum.get(sum);
            if (intervalNode != null) {
                intervalNode.next = head.next;
                return removeZeroSumSublists(originalHead);
            } else {
                prefixSum.put(sum, head);
            }
            head = head.next;
        }
        return originalHead;
    }


    public ListNode removeZeroSumSublist2s(ListNode head) {
        ListNode[] headNode = new ListNode[1];
        traverseAndEliminate(head, headNode);
        return headNode[0];
    }

    private void traverseAndEliminate(ListNode head, ListNode[] headNode) {
        headNode[0] = head;
        if (head == null) {
            return;
        }
        int prefixSum = 0;
        Map<Integer, ListNode> sumMap = new HashMap<>();
        ListNode targetSumNode;
        while (head != null) {
            prefixSum += head.val;
            if (prefixSum == 0) {
                traverseAndEliminate(head.next, headNode);
                return;
            } else {
                targetSumNode = sumMap.get(prefixSum);
                if (targetSumNode != null) {
                    targetSumNode.next = head.next;
                    traverseAndEliminate(headNode[0], headNode);
                    return;
                } else {
                    sumMap.put(prefixSum, head);
                }
            }
            head = head.next;
        }
    }
}
