package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.NodeWithRandom;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    // https://leetcode.com/problems/copy-list-with-random-pointer/
    public NodeWithRandom copyRandomList(NodeWithRandom head) {
        // null head
        if (head == null) {
            return null;
        }
        // single head
        if (head.next == null) {
            if (head.random == null) {
                return new NodeWithRandom(head.val);
            } else {
                NodeWithRandom newNode = new NodeWithRandom(head.val);
                newNode.random = newNode;
                return newNode;
            }
        }

        // else a  list with >1 elements
        NodeWithRandom originalHead = head;
        Map<NodeWithRandom, NodeWithRandom> oldToNew = new HashMap<>();
        while(head != null) {
            insertAndGetNewNode(head, oldToNew);
            head = head.next;
        }
        return oldToNew.get(originalHead);
    }

    private NodeWithRandom insertAndGetNewNode(NodeWithRandom oldNode, Map<NodeWithRandom, NodeWithRandom> oldToNew) {
        if (oldToNew.containsKey(oldNode)) {
            return oldToNew.get(oldNode);
        }
        NodeWithRandom newNode = new NodeWithRandom(oldNode.val);
        oldToNew.put(oldNode, newNode);
        if (oldNode.next != null) {
            newNode.next = insertAndGetNewNode(oldNode.next, oldToNew);
        }
        if (oldNode.random != null) {
            newNode.random = insertAndGetNewNode(oldNode.random, oldToNew);
        }
        return newNode;
    }
}
