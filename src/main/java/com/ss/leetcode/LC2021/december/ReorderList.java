package com.ss.leetcode.LC2021.december;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        nodeList.get(0).next = nodeList.get(size - 1);
        for (int i = 1, j = size -2; i < j; i++, j--) {
            nodeList.get(j + 1).next = nodeList.get(i);
            nodeList.get(i).next = nodeList.get(j);
            nodeList.get(j).next = null;
        }
        if (size % 2 != 0) {
            nodeList.get(size /2 + 1).next = nodeList.get(size /2);
            nodeList.get(size /2).next = null;
        }
    }
}
