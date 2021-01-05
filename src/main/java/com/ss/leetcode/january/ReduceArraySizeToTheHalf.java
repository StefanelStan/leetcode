package com.ss.leetcode.january;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReduceArraySizeToTheHalf {
    // https://leetcode.com/problems/reduce-array-size-to-the-half/
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int number : arr) {
            numbers.merge(number, 1, Integer::sum);
        }

        List<Integer> appearances = new LinkedList<>(numbers.values());
        appearances.sort(Comparator.reverseOrder());

        int removalsSum = 0;
        int times = 0;
        Iterator<Integer> it = appearances.iterator();
        while(removalsSum < arr.length / 2 && it.hasNext()) {
            removalsSum += it.next();
            times++;
        }

        return times;
    }
}
