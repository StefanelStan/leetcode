package com.ss.leetcode.june;

import com.ss.leetcode.shared.ListNode;

public class ConvertBinaryNumber {
    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
    public int getDecimalValue(ListNode head) {
        StringBuilder stb = new StringBuilder();
        stb.append(head.val);
        ListNode currentNode = head.next;
        while(currentNode != null) {
            stb.append(currentNode.val);
            currentNode = currentNode.next;
        }
        return Integer.parseInt(stb.toString(), 2);
    }
}


