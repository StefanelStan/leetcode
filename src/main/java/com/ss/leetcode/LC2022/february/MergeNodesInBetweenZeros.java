package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.ListNode;

public class MergeNodesInBetweenZeros {
    // https://leetcode.com/problems/merge-nodes-in-between-zeros/
    public ListNode mergeNodes(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode currentNewNode = null;
        int sum = 0;
        while (head != null) {
            while(head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            if (sum > 0) {
                if (preHead.next == null) {
                    preHead.next = new ListNode(sum);
                    currentNewNode = preHead.next;
                } else {
                    currentNewNode.next = new ListNode(sum);
                    currentNewNode = currentNewNode.next;
                }
                sum = 0;
            }
            head = head.next;
        }
        return preHead.next;
    }
}
