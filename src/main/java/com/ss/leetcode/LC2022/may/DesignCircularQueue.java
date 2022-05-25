package com.ss.leetcode.LC2022.may;

public class DesignCircularQueue {
    // https://leetcode.com/problems/design-circular-queue/
    private final int MAX_SIZE;
    private final int[] queue;
    private int head;
    private int tail;
    private int size;
    public DesignCircularQueue(int k) {
        queue = new int[k];
        MAX_SIZE = k;
    }

    public boolean enQueue(int value) {
        if (size == MAX_SIZE) {
            return false;
        } else {
            tail = (tail + 1) % MAX_SIZE;
            queue[tail] = value;
            if (size == 0) {
                head = tail;
            }
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        } else {
            head = (head + 1) % MAX_SIZE;
            if(size ==  1) {
                tail = head;
            }
        }
        size--;
        return true;
    }

    public int front() {
        if (size == 0) {
            return -1;
        } else {
            return queue[head];
        }
    }

    public int rear() {
        if (size == 0) {
            return -1;
        } else {
            return queue[tail];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }
}
