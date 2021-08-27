package com.ss.leetcode.shared;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public static ListNode makeChain(int[] args) {
        ListNode head = new ListNode(args[0]);
        ListNode currentNode = head;
        for (int i = 1; i < args.length; i++) {
            currentNode.next = new ListNode(args[i]);
            currentNode = currentNode.next;
        }
        return head;
    }

    public List<Integer> getAsList() {
        List<Integer> list = new LinkedList<>();
        list.add(val);
        ListNode nextNode = next;
        while(nextNode != null) {
            list.add(nextNode.val);
            nextNode = nextNode.next;
        }
        return list;
    }
}
