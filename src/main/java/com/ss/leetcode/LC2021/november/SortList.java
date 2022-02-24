package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {
    // https://leetcode.com/problems/sort-list/
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort(Comparator.comparingInt(n -> n.val));
        for(int i = 1; i < nodes.size(); i++) {
            nodes.get(i-1).next = nodes.get(i);
        }
        nodes.get(nodes.size() -1).next = null;
        return nodes.get(0);
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-100_001, new ListNode(head.val));
        head = head.next;
        if (head == null) {
            return preHead.next;
        }
        ListNode[][] minMax = new ListNode[2][2];
        ListNode newNode = new ListNode(head.val);
        if (newNode.val <= preHead.next.val) {
            newNode.next = preHead.next;
            preHead.next = newNode;
            minMax[0][0] = preHead;
            minMax[0][1] = newNode;
            minMax[1][0] = newNode;
            minMax[1][1] = newNode.next;
        } else {
            preHead.next.next = newNode;
            minMax[0][0] = preHead;
            minMax[0][1] = preHead.next;
            minMax[1][0] = preHead.next;
            minMax[1][1] = newNode;
        }
        head = head.next;
        while (head != null) {
            appendInOrder(preHead, new ListNode(head.val), minMax);
            head = head.next;
        }
        return preHead.next;
    }

    private void appendInOrder(ListNode preHead, ListNode newNode, ListNode[][] minMax) {
        if (newNode.val <= minMax[0][1].val) {
            minMax[0][0].next = newNode;
            newNode.next = minMax[0][1];
            minMax[0][1] = newNode;
            return;
        }

        if (newNode.val >= minMax[1][1].val) {
            minMax[1][0] = minMax[1][1];
            minMax[1][0].next = newNode;
            minMax[1][1] = newNode;
            return;
        }

        ListNode nextHead = preHead.next;
        while (nextHead != null) {
            if (preHead.val <= newNode.val && newNode.val <= nextHead.val) {
                preHead.next = newNode;
                newNode.next = nextHead;
                return;
            }
            preHead = nextHead;
            nextHead = nextHead.next;
        }
        preHead.next = newNode;
    }
}
