package com.ss.leetcode.LC2024.july;

public class FindTheWinnerOfTheCircularGame {
    // https://leetcode.com/problems/find-the-winner-of-the-circular-game
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        ListNode next = buildList(n);
        while(n > 2) {
            next = eliminateNode(next, k);
            n--;
        }
        return k % 2 == 1 ? next.next.value : next.value;
    }

    private ListNode eliminateNode(ListNode from, int k) {
        ListNode prev = from;
        while (k > 1) {
            prev = from;
            from = from.next;
            k--;
        }
        prev.next = from.next;
        return prev.next;
    }


    private ListNode buildList(int n) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for (int i = 2; i <= n; i++) {
            ListNode newNode = new ListNode(i);
            prev.next = newNode;
            prev = newNode;
        }
        prev.next = head;
        return head;
    }

    private static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
