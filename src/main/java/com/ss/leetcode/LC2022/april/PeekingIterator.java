package com.ss.leetcode.LC2022.april;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    // https://leetcode.com/problems/peeking-iterator/submissions/
    /** Algorithm
         1. In order to simulate a peek, we will actually to a next() and store the result in a bucket.
         This bucket will server as peek (each time a peek is needed) or next.
         2. Peek: if the bucket is empty (eg: -1), do a next() and store/cache the value in the bucket.
         3. Next: if the bucket is not empty, return the bucket and reset it.
         4. HasNext : check if it.hasNext() OR if there is one element in the bucket.
     */
    private final Iterator<Integer> it;
    private int bucket = -1;
    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(bucket == -1) {
            bucket = it.next();
        }
        return bucket;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int toReturn = bucket;
        if (toReturn == -1) {
            toReturn = it.next();
        }
        bucket = -1;
        return toReturn;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext() || bucket != -1;
    }
}
