package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII {
    // https://leetcode.com/problems/add-two-numbers-ii/
    /** Algorithm
     *  1. Use the stack to memory space to operate over current node or nodes. If the returned values from calling appendNodes(next)
     *    is 1, add it to longList.val
     *  2. Get their sizes and differences (how many steps need to be skipped from long list tor each an index matching start of shortList
     *  3. Add current shortList or 0 to carryOver + longList.val, overriding longList.val
     *  4. If final carryOVer is 1, add new node in front of longList.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] sizes = getSizes(l1, l2);
        ListNode longList = sizes[0] <= sizes[1] ? l2 : l1;
        ListNode shortList = sizes[0] <= sizes[1] ? l1 : l2;
        int carryOver = appendNodes(longList, shortList, Math.abs(sizes[0] - sizes[1]));
        return carryOver == 1 ? new ListNode(1, longList) : longList;
    }

    private int appendNodes(ListNode longList, ListNode shortList, int diff) {
        if (longList == null) {
            return 0;
        }
        int carryOver = diff > 0
            ? appendNodes(longList.next, shortList, diff -1)
            : appendNodes(longList.next, shortList.next, diff - 1);
        int sum = diff > 0  ? longList.val + carryOver : longList.val + carryOver + shortList.val;
        longList.val = sum % 10;
        return sum / 10;
    }

    private int[] getSizes(ListNode l1, ListNode l2) {
        int[] sizes = {0,0};
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1 = l1.next;
                sizes[0]++;
            }
            if (l2 != null) {
                l2 = l2.next;
                sizes[1]++;
            }
        }
        return sizes;
    }



    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int[] l1Size = {0};
        int[] l2Size = {0};
        ListNode l1Rev = reverse(l1, l1Size);
        ListNode l2Rev = reverse(l2, l2Size);
        ListNode longNode = l1Size[0] > l2Size[0] ? l1Rev : l2Rev;
        ListNode shortNode = longNode == l1Rev ? l2Rev : l1Rev;
        ListNode ln = longNode;
        int carryOver = 0, tempSum = 0;
        while (true) {
            if (shortNode != null) {
                tempSum = longNode.val + shortNode.val + carryOver;
                shortNode = shortNode.next;
            } else {
                tempSum = longNode.val + carryOver;
            }
            longNode.val = tempSum  % 10;
            carryOver = tempSum / 10;
            if(longNode.next != null) {
                longNode = longNode.next;
            } else {
                break;
            }
        }
        if (carryOver > 0) {
            longNode.next = new ListNode(carryOver);
        }
        return reverse(ln, new int[]{0});
    }

    private ListNode reverse(ListNode head, int[] size) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            size[0]++;
        }
        return prev;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Deque<Integer> l1Digits = new LinkedList<>();
        Deque<Integer> l2Digits =  new LinkedList<>();
        while(l1 != null){
            l1Digits.offer(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            l2Digits.offer(l2.val);
            l2 = l2.next;
        }

        ListNode currentNode = null;
        int carryOver = 0, tempSum = 0;
        while(!l1Digits.isEmpty() || !l2Digits.isEmpty()) {
            if (!l1Digits.isEmpty()) {
                tempSum += l1Digits.removeLast();
            }
            if(!l2Digits.isEmpty()) {
                tempSum += l2Digits.removeLast();
            }

            tempSum += carryOver;
            currentNode = new ListNode(tempSum % 10, currentNode);
            carryOver = tempSum / 10;
            tempSum = 0;
        }
        if (carryOver > 0) {
            currentNode = new ListNode(1, currentNode);
        }
        return currentNode;
    }
}
