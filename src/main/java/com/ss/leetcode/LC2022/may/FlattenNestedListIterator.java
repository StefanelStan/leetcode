package com.ss.leetcode.LC2022.may;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
    // https://leetcode.com/problems/flatten-nested-list-iterator/
    private final LinkedList<Integer> allInts;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        allInts = new LinkedList<>();
        traverseInts(nestedList);
    }

    @Override
    public Integer next() {
        return allInts.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !allInts.isEmpty();
    }

    private void traverseInts(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                allInts.add(ni.getInteger());
            } else {
                traverseInts(ni.getList());
            }
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class MyNestedInteger implements NestedInteger {
        Integer val;
        List<NestedInteger> list;
        public MyNestedInteger(Integer val) {
            this.val = val;
        }

        public MyNestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return val != null;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
