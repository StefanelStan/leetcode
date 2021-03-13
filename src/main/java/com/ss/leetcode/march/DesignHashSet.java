package com.ss.leetcode.march;

public class DesignHashSet {
    private final boolean[] mySet =  new boolean[1_000_001];

    public void add(int key) {
        mySet[key] = true;
    }

    public void remove(int key) {
        mySet[key] = false;
    }

    public boolean contains(int key) {
        return mySet[key];
    }
}
