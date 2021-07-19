package com.ss.leetcode.july;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInkGroup {
    // https://leetcode.com/problems/reverse-nodes-in-k-group/
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        List<ListNode> nodePositions = mapNodes(head);
        reverseNodes(nodePositions, k);
        repairLinks(nodePositions);
        return nodePositions.get(0);
    }

    private List<ListNode> mapNodes(ListNode head) {
        List<ListNode> nodePositions = new ArrayList<>();
        nodePositions.add(head);
        ListNode nextNode = head.next;
        while (nextNode != null) {
            nodePositions.add(nodePositions.size(), nextNode);
            nextNode = nextNode.next;
        }
        return nodePositions;
    }

    private void reverseNodes(List<ListNode> nodePositions, int k) {
        ListNode tmp = null;
        for (int i = 0; i < nodePositions.size() - nodePositions.size() % k; i += k) {
            for (int front = 0, end = k - 1; front <= end; front++, end--) {
                tmp = nodePositions.get(i + front);
                nodePositions.set(i + front, nodePositions.get(i + end));
                nodePositions.set(i + end, tmp);
            }
        }
    }

    private void repairLinks(List<ListNode> nodePositions) {
        for (int i = 0; i < nodePositions.size() - 1; i++) {
            nodePositions.get(i).next = nodePositions.get(i + 1);
        }
        nodePositions.get(nodePositions.size() - 1).next = null;
    }
}
