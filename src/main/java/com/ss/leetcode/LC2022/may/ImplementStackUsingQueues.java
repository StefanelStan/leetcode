package com.ss.leetcode.LC2022.may;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> main;
    Queue<Integer> backup;
    int cachedLastElement = -1;
    public ImplementStackUsingQueues() {
        main = new LinkedList<>();
        backup = new LinkedList<>();
    }

    public void push(int x) {
        if (backup.isEmpty()) {
            main.add(x);
        } else {
            backup.add(x);
        }
        cachedLastElement = x;
    }

    public int pop() {
        return removeLastAddedElement();
    }

    public int top() {
        return cachedLastElement;
    }

    public boolean empty() {
        return main.isEmpty() && backup.isEmpty();
    }

    private int removeLastAddedElement() {
        Queue<Integer> full = main.isEmpty() ? backup : main;
        Queue<Integer> empty = main.isEmpty() ? main : backup;
        if (full.size() == 1) {
            cachedLastElement = -1;
            return full.poll();
        }
        int previous = -1, last = -1;
        while(!full.isEmpty()) {
            last = full.poll();
            if (!full.isEmpty()) {
                empty.add(last);
                previous = last;
            }
        }
        cachedLastElement = previous;
        return last;
    }
}
