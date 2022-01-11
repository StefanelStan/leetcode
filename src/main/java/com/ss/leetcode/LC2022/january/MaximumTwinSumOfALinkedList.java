package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfALinkedList {
    // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public int pairSum(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        int maxPairSum = 0;
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        for (int i = 0, j = nodes.size() -1; i < j; i++, j--) {
            maxPairSum = Math.max(maxPairSum, nodes.get(i).val + nodes.get(j).val);
        }
        return maxPairSum;
    }
}
