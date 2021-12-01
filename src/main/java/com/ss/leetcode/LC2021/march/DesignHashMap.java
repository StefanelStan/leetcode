package com.ss.leetcode.LC2021.march;

import java.util.Arrays;

public class DesignHashMap {
    private final int[] myHashMap;
    // https://leetcode.com/problems/design-hashmap/
    public DesignHashMap() {
        myHashMap = new int[1_000_001];
    }

    public void put(int key, int value) {
        if (value == 0) {
            myHashMap[key] = -1;
        } else {
            myHashMap[key] = value;
        }
    }

    public int get(int key) {
        if (myHashMap[key] == -1) {
            return 0;
        }
        else if(myHashMap[key] == 0) {
            return -1;
        } else {
            return myHashMap[key];
        }
    }

    public void remove(int key) {
        myHashMap[key] = 0;
    }
}
