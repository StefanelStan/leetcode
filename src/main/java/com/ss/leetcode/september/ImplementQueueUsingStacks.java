package com.ss.leetcode.september;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    // https://leetcode.com/problems/implement-queue-using-stacks/
    private final Stack<Integer> normal;
    private final Stack<Integer> reverse;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        this.normal = new Stack<>();
        this.reverse =  new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        moveElements(reverse, normal);
        normal.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        moveElements(normal, reverse);
        return reverse.pop();
    }

    /** Get the front element. */
    public int peek() {
        return normal.isEmpty() ? reverse.peek() : normal.firstElement();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return normal.isEmpty() && reverse.isEmpty();
    }

    private void moveElements(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
