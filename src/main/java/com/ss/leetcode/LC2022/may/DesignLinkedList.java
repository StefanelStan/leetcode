package com.ss.leetcode.LC2022.may;

public class DesignLinkedList {
    // https://leetcode.com/problems/design-linked-list/
    private int size;
    private Node head;
    private Node tail;
    public DesignLinkedList() {
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return getNodeAtIndex(index).val;
    }

    public void addAtHead(int val) {
        if (size == 0) {
            tail = new Node(val);
            head = tail;
        } else if (size == 1) {
            Node newHead = new Node(val);
            newHead.next = head;
            head.prev = newHead;
            tail = head;
            head = newHead;
        } else {
            Node newHead = new Node(val, head, null);
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node newTail = new Node(val);
            tail.next = newTail;
            newTail.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node existingNode = getNodeAtIndex(index);
            Node before = existingNode.prev;
            Node newNode = new Node(val, existingNode, before);
            before.next = newNode;
            existingNode.prev = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (size == 0 || index >= size) {
            return;
        }
        if(index == 0) {
            if (size > 1) {
                head = head.next;
                head.prev = null;
            } else {
                head = null;
                tail = null;
            }
        } else if (index == size -1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node targetNode = getNodeAtIndex(index);
            targetNode.prev.next = targetNode.next;
            targetNode.next.prev = targetNode.prev;
        }
        size--;
    }

    private Node getNodeAtIndex(int index) {
        Node targetNode;
        if(index > size /2) {
            targetNode = getFromBottom(size - index -1);
        } else {
            targetNode = getFromHead(index);
        }
        return targetNode;
    }

    private Node getFromBottom(int index) {
        Node tempTail = tail;
        while(index > 0) {
            tempTail = tempTail.prev;
            index--;
        }
        return tempTail;
    }

    private Node getFromHead(int index) {
        Node tempHead = head;
        while (index > 0) {
            tempHead = tempHead.next;
            index--;
        }
        return tempHead;
    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this(val, null, null);
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
