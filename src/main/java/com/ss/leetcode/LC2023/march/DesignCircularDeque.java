package com.ss.leetcode.LC2023.march;

public class DesignCircularDeque {
    // https://leetcode.com/problems/design-circular-deque/
    /** Algorithm
        1. Use an int[k] to insert elements into the queue.
        2. Use 2 pointers (head, tail) to keep them positioned on the current head and tail. Also, keep track of current queue size.
        3. If size == 0, you return -1 as you cannot delete from head/tail. If size == queue.length, you cannot insert head/tail.
        4. Insert (Same idea for deletion)
            - if your size is 0, then set your queue[head] or queue[tail] value and increase the size.
            - if size > 0, then move head to left or tail to right and set the value of that index. Increase the size.
     */
    int head = 0, tail = 0, size = 0;
    int[] queue;
    public DesignCircularDeque(int k) {
        queue = new int[k];
    }

    public boolean insertFront(int value) {
        if (size < queue.length) {
            if (size > 0) {
                head = head == 0 ? queue.length -1 : head - 1;
            }
            queue[head] = value;
            size++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (size < queue.length) {
            if (size > 0) {
                tail = (tail + 1) % queue.length;
            }
            queue[tail] = value;
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (size > 0) {
            if (size > 1) {
                head = (head + 1) % queue.length;
            }
            size--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (size > 0) {
            if (size > 1) {
                tail = tail == 0 ? queue.length -1 : tail - 1;
            }
            size--;
            return true;
        }
        return false;
    }

    public int getFront() {
        return size == 0 ? -1 : queue[head];
    }

    public int getRear() {
        return size == 0 ? -1 : queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
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
