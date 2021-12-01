package com.ss.leetcode.LC2021.october;

import java.util.ArrayList;
import java.util.List;

public class FlattenAMultilevelDoublyLL {
    // https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    public Node flatten(Node head) {
        Node headNode = head;
        while (head != null) {
            if (head.child != null) {
                Node nextInLine = head.next;
                Node firstChild = head.child;
                Node lastChild = getLastChild(head);
                head.next = firstChild;
                firstChild.prev = head;
                lastChild.next = nextInLine;
                head.child = null;
                if(nextInLine != null) nextInLine.prev = lastChild;
                head = firstChild;
            } else {
                head = head.next;
            }
        }
        return headNode;
    }

    private Node getLastChild(Node parent) {
        parent = parent.child;
        while (parent.next != null) {
            parent = parent.next;
        }
        return parent;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public static void connect(Node node1, Node node2) {
            node1.next = node2;
            node2.prev = node1;
        }

        public static List<Integer> toList(Node node) {
            List<Integer> values = new ArrayList<>();
            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
            return values;
        }
    }
}
