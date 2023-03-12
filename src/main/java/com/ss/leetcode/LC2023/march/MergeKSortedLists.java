package com.ss.leetcode.LC2023.march;

import com.ss.leetcode.shared.ListNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLists {
    // https://leetcode.com/problems/merge-k-sorted-lists/
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> sortedLists = new ArrayList<>();
        for (ListNode l : lists) {
            addToSortedLists(sortedLists, l);
        }
        Collections.sort(sortedLists, Comparator.comparingInt(node -> node.val));
        for (int i = 0; i < sortedLists.size() - 1; i++) {
            sortedLists.get(i).next = sortedLists.get(i+1);
        }
        if (!sortedLists.isEmpty()) {
            sortedLists.get(sortedLists.size() -1).next = null;
        }
        return sortedLists.isEmpty() ? null : sortedLists.get(0);
    }

    private void addToSortedLists(List<ListNode> sortedLists, ListNode head) {
        while (head != null) {
            sortedLists.add(head);
            head = head.next;
        }
    }
}
