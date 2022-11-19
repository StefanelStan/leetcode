package com.ss.leetcode.LC2022.november;

public class LRUCache {
    /** Algorithm
         1. Studying LRU, you can understand that you need a FIFO data structure (first in, first out or QUEUE).
            The first elements in the queue become the "oldest" and should be evicted first, accordingly
         2. Probably, now you have imagined that you can use a Queue, preferably a double linked list.
             When you do a get to an element from the middle, (eg: 1,2,3,4 ; get (2)) , 2 will have to be taken out from the queue and
            put at the end, relinking previous with the next element.
         3. Thus, declare an object CachedObject {previous, next, key, value}
         4. For highly optimized solutions, use a [10_001] to map the of each int key - value against the CachedObject in memory (faster than maps!)
         5. Get: if cache[key] == null, return -1, else move the CachedObject at the end (after tail). Pay attention when breaking the links.
         6. Put: if key exists, check against the current size and either add new tail OR evict head and add new tail.
     */
    private final int maxCapacity;
    private int currentSize;
    private final CachedObject[] cache;
    CachedObject head, tail;
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        cache = new CachedObject[10_001];
    }

    public int get(int key) {
        CachedObject cached = cache[key];
        if (cached != null) {
            if (cached != tail && currentSize > 1) { // do not move the node if the node is already at the tail.
                if (cached == head) {
                    // set new head and put this at the end;
                    moveHeadLinkAtTheEnd(cached);
                } else {
                    moveIntermediaryLink(cached);
                }
            }
            tail = cached;
            return tail.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (currentSize == 0) {
            cache[key] = new CachedObject(key, value);
            head = cache[key];
            tail = cache[key];
            currentSize++;
        } else {
            CachedObject cached = cache[key];
            if (cached == null) {
                addNewValue(key, value);
            } else {
                modifyCurrentValue(cached, value);
            }
        }
    }

    private void addNewValue(int key, int value) {
        CachedObject newCache = new CachedObject(key, value);
        cache[key] = newCache;
        // we can add a new element at the tail because the max capacity has not been reached
        if (currentSize < maxCapacity) {
            if (currentSize == 0) {
                head = newCache;
                tail = newCache;
            } else {
                tail.next = newCache;
                newCache.previous = tail;
                tail = newCache;
            }
            currentSize++;
        } else { // max capacity has been reached, so we need to delete head and add this new node at the end
            cache[head.key] = null;
            if (maxCapacity == 1) {
                head = newCache;
            } else {
                // evict head
                head.next.previous = null;
                // avoid memory leak and break the link from head.next to the next-to-become head.
                // moving head = head.next will move the head pointer but this head will still persist in memory
                // because it is referencing the new head in head.next.
                CachedObject headSnapshot = head;
                head = head.next;
                headSnapshot.next = null;
                // add new element at the tail
                tail.next = newCache;
                newCache.previous = tail;
            }
            tail = newCache;
        }
    }

    private void modifyCurrentValue(CachedObject cached, int value) {
        cached.value = value;
        if (cached != tail && currentSize > 1) {
            if (cached == head) {
                // set new head and put this at the end;
                moveHeadLinkAtTheEnd(cached);
            } else {
                moveIntermediaryLink(cached);
            }
            tail = cached;
        }
    }

    // move the current head at the end and make head to point to next in line/queue
    private void moveHeadLinkAtTheEnd(CachedObject cached) {
        head = cached.next;
        cached.next.previous = null;
        cached.previous = tail;
        tail.next = cached;
        cached.next = null;
    }

    // the target node sits somewhere between head and tail, so we have a guaranteed next and previous that need linking
    private void moveIntermediaryLink(CachedObject cached) {
        // relink previous with next;
        cached.previous.next = cached.next;
        cached.next.previous = cached.previous;
        // put cached at the end
        cached.previous = tail;
        tail.next = cached;
        cached.next = null;
    }

    private static class CachedObject {
        CachedObject previous;
        CachedObject next;
        int key;
        int value;

        public CachedObject(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
