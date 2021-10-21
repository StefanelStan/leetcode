package com.ss.leetcode.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandomO1 {
    // https://leetcode.com/problems/insert-delete-getrandom-o1/
    private List<Integer> items;
    private Map<Integer, Integer> itemsPos;

    public InsertDeleteGetRandomO1() {
        items = new ArrayList<>();
        itemsPos = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!itemsPos.containsKey(val)) {
            itemsPos.put(val, items.size());
            items.add(val);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        Integer pos = itemsPos.remove(val);
        if (pos != null) {
            if (pos < items.size() - 1) {
                items.set(pos, items.get(items.size() - 1));
                itemsPos.put(items.get(items.size() - 1), pos);
            }
            items.remove(items.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return items.get(ThreadLocalRandom.current().nextInt(items.size()));
    }
}
