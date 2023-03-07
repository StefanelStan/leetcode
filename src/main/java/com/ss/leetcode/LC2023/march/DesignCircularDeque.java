package com.ss.leetcode.LC2023.march;

public class DesignCircularDeque {
    // https://leetcode.com/problems/design-circular-deque/
    private int[] queue;
    private int capacity, size;
    private int head, tail;
    public DesignCircularDeque(int k) {
        capacity = k;
        queue = new int[k];
        head = tail = k-1;
    }

    public boolean insertFront(int value) {
        boolean result = false;
        if (!isFull()) {
           head--;
           if (head < 0) {
               head = capacity - 1;
           }
           queue[head] = value;
           result = true;
           if(++size <= 1) {
               tail = head;
           }
        }
        return result;
    }

    public boolean insertLast(int value) {
        boolean result = false;
        if(!isFull()) {
            tail = (tail + 1) % capacity;
            if (++size <= 1) {
                head = tail;
            }
            queue[tail] = value;
            result = true;
        }
        return result;
    }

    public boolean deleteFront() {
        boolean result = false;
        if(!isEmpty()) {
            head = (head + 1) % capacity;
            if(--size <= 1) {
                tail = head;
            }
            result = true;
        }

        return result;
    }

    public boolean deleteLast() {
        boolean result = false;
        if (!isEmpty()) {
            tail--;
            if (tail < 0) {
                tail = capacity -1;
            }
            if(-- size <= 1) {
                head = tail;
            }
            result = true;
        }
        return result;
    }

    public int getFront() {
        int result = -1;
        if (!isEmpty()) {
            result = queue[head];
        }
        return result;
    }

    public int getRear() {
        int result = -1;
        if (!isEmpty()) {
            result = queue[tail];
        }
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }



    /**
    private final int maxCapacity;
    private int size;
    private Node head;
    private Node tail;

    public DesignCircularDeque(int k) {
        maxCapacity = k;
    }

    public boolean insertFront(int value) {
        if(maxCapacity == size) {
            return false;
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(maxCapacity == size) {
            return false;
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size ==1) {
            head = tail = null;
        } else {
            Node next = head.next;
            head.next.previous = null;
            head.next = null;
            head = next;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if(size == 1) {
            head = tail = null;
        } else {
            Node prev = tail.previous;
            tail.previous.next = null;
            tail.previous = null;
            tail = prev;
        }
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty()? -1 : head.value;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return maxCapacity == size;
    }

    private static class Node {
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
        }
    }
     */
}
