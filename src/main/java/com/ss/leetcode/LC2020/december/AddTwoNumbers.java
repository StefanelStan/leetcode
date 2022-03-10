package com.ss.leetcode.LC2020.december;

import com.ss.leetcode.shared.ListNode;

public class AddTwoNumbers {
    // https://leetcode.com/problems/add-two-numbers/submissions/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;
        int sum = 0, carryOver = 0;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carryOver;
            carryOver = sum > 9 ? 1 : 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            calculateSum(l2, carryOver, current);
        } else if (l1 != null) {
            calculateSum(l1, carryOver, current);
        } else if (carryOver == 1) {
            current.next = new ListNode(1);
        }
        return preHead.next;
    }

    private void calculateSum(ListNode node, int carryOver, ListNode current) {
        int sum;
        while(node != null) {
            sum = node.val + carryOver;
            carryOver = sum > 9 ? 1 : 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            node = node.next;
        }
        if (carryOver == 1) {
            current.next = new ListNode(1);
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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

