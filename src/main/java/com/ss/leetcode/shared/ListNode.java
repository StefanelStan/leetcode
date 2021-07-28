package com.ss.leetcode.shared;

import com.ss.leetcode.june.ConvertBinaryNumber;

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
        ListNode[] chain = new ListNode[args.length];
        chain[args.length -1] = new ListNode(args[args.length-1]);
        for (int i= args.length -2; i >=0; i--) {
            chain[i] = new ListNode(args[i], chain[i+1]);
        }
        return chain[0];
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
