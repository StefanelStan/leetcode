package com.ss.leetcode.june;

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }

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
    }
}


