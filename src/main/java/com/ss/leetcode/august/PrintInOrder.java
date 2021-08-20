package com.ss.leetcode.august;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
    // https://leetcode.com/problems/print-in-order/
    Lock lock = new ReentrantLock();
    AtomicInteger state = new AtomicInteger(1);
    public PrintInOrder() {
    }

    public void first(Runnable printFirst) {
        while(true) {
            lock.lock();
            if (state.get() == 1) {
                printFirst.run();
                state.set(2);
                lock.unlock();
                break;
            } else {
                lock.unlock();
            }
        }
    }

    public void second(Runnable printSecond) {
        while(true) {
            lock.lock();
            if (state.get() == 2) {
                printSecond.run();
                state.set(3);
                lock.unlock();
                break;
            } else {
                lock.unlock();
            }
        }
    }

    public void third(Runnable printThird) {
        while(true) {
            lock.lock();
            if (state.get() == 3) {
                printThird.run();
                state.set(1);
                lock.unlock();
                break;
            } else {
                lock.unlock();
            }
        }
    }
}
