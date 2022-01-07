package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    private final List<ListNode> nodes;
    private final Random rand;
    public LinkedListRandomNode(ListNode head) {
        nodes = new ArrayList<>();
        rand = new Random();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
    }

    public int getRandom() {
        //return nodes.get(ThreadLocalRandom.current().nextInt(nodes.size())).val;
        return nodes.get(rand.nextInt(nodes.size())).val;
    }
}
