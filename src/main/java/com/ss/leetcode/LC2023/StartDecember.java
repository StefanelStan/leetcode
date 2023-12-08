package com.ss.leetcode.LC2023;

import com.ss.leetcode.LC2023.december.MinimumAdditionsToMakeValidString;
import com.ss.leetcode.LC2023.december.PartitionStringIntoMinimumBeautifulSubstrings;
import com.ss.leetcode.LC2023.december.RemoveZeroSumConsecutiveNodesFromLinkedList;
import com.ss.leetcode.shared.ListNode;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.partitionStringIntoMinimumBeautifulSubstrings();
//        start.minimumAdditionsToMakeValidString();
        start.removeZeroSumConsecutiveNodesFromLinkedList();
    }

    public void partitionStringIntoMinimumBeautifulSubstrings() {
        PartitionStringIntoMinimumBeautifulSubstrings psimbs = new PartitionStringIntoMinimumBeautifulSubstrings();

        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1011"));
        System.out.println("3 == " + psimbs.minimumBeautifulSubstrings("111"));
        System.out.println("-1 == " + psimbs.minimumBeautifulSubstrings("0"));
        System.out.println("2 == " + psimbs.minimumBeautifulSubstrings("1100001101011"));
        System.out.println("4 == " + psimbs.minimumBeautifulSubstrings("100111000110111"));
    }

    public void minimumAdditionsToMakeValidString() {
        MinimumAdditionsToMakeValidString matmvs = new MinimumAdditionsToMakeValidString();

        System.out.println("2 == " + matmvs.addMinimum("b"));
        System.out.println("6 == " + matmvs.addMinimum("aaa"));
        System.out.println("0 == " + matmvs.addMinimum("abc"));
    }

    public void removeZeroSumConsecutiveNodesFromLinkedList() {
        RemoveZeroSumConsecutiveNodesFromLinkedList rzscnfll = new RemoveZeroSumConsecutiveNodesFromLinkedList();

        System.out.println("[3,1] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,-3,3,1})).getAsList());
        System.out.println("[1,2,4] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,3,-3,4})).getAsList());
        System.out.println("[1] == " + rzscnfll.removeZeroSumSublists(ListNode.makeChain(new int[]{1,2,3,-3,-2})).getAsList());
    }
}
