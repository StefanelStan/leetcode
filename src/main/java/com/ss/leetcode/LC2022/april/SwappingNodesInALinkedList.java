package com.ss.leetcode.LC2022.april;

import com.ss.leetcode.shared.ListNode;

public class SwappingNodesInALinkedList {
    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
    // This swaps the values, not the nodes.
    public ListNode swapNodes(ListNode head, int k) {
        ListNode originalHead = head;
        int size = 0;
        ListNode firstK = null;
        while (head != null) {
            size++;
            if (size == k) {
                firstK = head;
            }
            head = head.next;
        }
        ListNode from;
        ListNode secondK = null;
        int distance;
        if (2 * k <= size) {
            from = firstK;
            distance = size - 2 * k + 1;
        } else {
            from = originalHead;
            distance = size - k;
        }
        while (distance >= 0 && from != null) {
            secondK = from;
            from = from.next;
            distance--;
        }
        int temp = firstK.val;
        firstK.val = secondK.val;
        secondK.val = temp;
        return originalHead;
    }

    // This Actually swaps two nodes
    public ListNode swapNodes2(ListNode head, int k) {
        int[] size = {0};
        ListNode[] firstKPrevAndNode = getNodeWindowOnPosition(head, k, size);
        if (size[0] % 2 == 1 && k == size[0] / 2 + 1) {
            return head;
        }
        int otherPos = (size[0] - k) + 1;
        ListNode[] secondKPrevAndNode = getNodeWindowOnPosition(head, otherPos, null);
        swapNodes(firstKPrevAndNode, secondKPrevAndNode, size[0], k);
        return k == 1
            ? secondKPrevAndNode[1]
            : k == size[0] ? firstKPrevAndNode[1] : head;
    }

    private void swapNodes(ListNode[] firstK, ListNode[] secondK, int size, int k) {
        ListNode[] left = 2 * k <= size ? firstK : secondK;
        ListNode[] right = 2 * k <= size ? secondK : firstK;
        // edge case when left.next == right;
        if (left[1].next == right[1]) {
            if (left[0] != null) {
                left[0].next = right[1];
            }
            left[1].next = right[1].next;
            right[1].next = left[1];
        } else {
            // any two random nodes
            if (left[0] != null) {
                left[0].next = right[1];
            }
            ListNode leftNext = left[1].next;
            left[1].next = right[1].next;
            right[1].next = leftNext;
            right[0].next = left[1];
        }

    }

    private ListNode[] getNodeWindowOnPosition(ListNode head, int k, int[] size) {
        ListNode[] prevAndNode = new ListNode[2];
        while (head != null && (k > 0 || size != null)) {
            if (k > 0) {
                prevAndNode[0] = prevAndNode[1];
                prevAndNode[1] = head;
                k--;
            }
            head = head.next;
            if (size != null) {
                size[0]++;
            }
        }
        return prevAndNode;
    }


    public ListNode swapNodes3(ListNode head, int k) {
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
