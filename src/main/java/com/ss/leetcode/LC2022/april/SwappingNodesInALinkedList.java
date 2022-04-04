package com.ss.leetcode.LC2022.april;

import com.ss.leetcode.shared.ListNode;

public class SwappingNodesInALinkedList {
    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(0, head);

        ListNode[] frontKNode = firstKNode(preHead, head, k);
        ListNode[] lastKNode = new ListNode[]{preHead, head};
        shiftWindow(lastKNode, new ListNode[]{frontKNode[0], frontKNode[1]});
        swapWindowEdges(frontKNode, lastKNode);
        return preHead.next;
    }

    private ListNode[] firstKNode(ListNode preHead, ListNode head, int k) {
        ListNode[] windowEnd = {preHead, head};
        k--;
        while(k > 0) {
            windowEnd[0] = windowEnd[1];
            windowEnd[1] = head.next;
            head = head.next;
            k--;
        }
        return windowEnd;
    }

    private void shiftWindow(ListNode[] windowStart, ListNode[] windowEnd) {
        while(windowEnd[1].next != null) {
            windowEnd[0] = windowEnd[1];
            windowEnd[1] = windowEnd[1].next;

            windowStart[0] = windowStart[1];
            windowStart[1] = windowStart[1].next;
        }
    }

    private void swapWindowEdges(ListNode[] frontKNode, ListNode[] lastKNode) {
        // detect cycle!
        ListNode nextTail = lastKNode[1].next;
        if (frontKNode[1] == lastKNode[0]) {
            frontKNode[0].next = lastKNode[1];
            lastKNode[1].next = frontKNode[1];
            frontKNode[1].next = nextTail;
            return;
        }
        if (frontKNode[0] == lastKNode[0]) {
            return;
        }

        if(frontKNode[0] == lastKNode[1]) {
            ListNode nextT = frontKNode[1].next;
            lastKNode[0].next = frontKNode[1];
            frontKNode[1].next = lastKNode[1];
            lastKNode[1].next = nextT;
            return;
        }

        frontKNode[0].next = lastKNode[1];
        lastKNode[1].next = frontKNode[1].next;
        frontKNode[1].next = nextTail;
        lastKNode[0].next = frontKNode[1];
    }
}
