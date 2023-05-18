package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfALinkedList {
    // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public int pairSum(ListNode head) {
        int size = 0;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            size += 2;
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }
        return getMaxPairSum(head, slow.next, size);
    }

    private int getMaxPairSum(ListNode left, ListNode right, int size) {
        int max = 0;
        int[] pairSum = new int[size /2];
        int i = 0, j = size/2;
        while (right != null) {
            pairSum[i] += left.val;
            pairSum[size - (1 + j)] += right.val;
            max = Math.max(max, Math.max(pairSum[i], pairSum[size - (1 + j)]));
            left = left.next;
            right = right.next;
            i++;
            j++;
        }
        return max;
    }


    public int pairSum2(ListNode head) {
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
