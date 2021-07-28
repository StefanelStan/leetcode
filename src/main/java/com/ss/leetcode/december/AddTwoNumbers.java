package com.ss.leetcode.december;

import com.ss.leetcode.shared.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String result = getResultAsString(l1, l2);
        ListNode firstNode = getResultAsLinkedList(result);
        return firstNode;
    }

    private String getResultAsString(ListNode l1, ListNode l2) {
        StringBuilder stb = new StringBuilder();
        int leftPart = 0;
        int rightPart = 0;
        int carriedOver = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if(l1 != null) {
                leftPart = l1.val;
            }
            if(l2 != null) {
                rightPart = l2.val;
            }
            sum = leftPart + rightPart + carriedOver;
            if (sum > 9) {
                stb.append(sum - 10);
                carriedOver = 1;
            } else {
                stb.append(sum);
                carriedOver = 0;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            leftPart = 0;
            rightPart = 0;
        }
        if (carriedOver ==1) {
            stb.append(1);
        }
        return stb.toString();
    }


    private ListNode getResultAsLinkedList(String result) {
        ListNode head = new ListNode(Integer.parseInt(result.charAt(0) + ""));
        ListNode currentNode = head;
        if(result.length() == 1) {
            return head;
        } else {
            for (int i =1 ; i< result.length(); i++) {
                ListNode newNode = new ListNode(Integer.parseInt(result.charAt(i) + ""));
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }
        return head;
    }
}

