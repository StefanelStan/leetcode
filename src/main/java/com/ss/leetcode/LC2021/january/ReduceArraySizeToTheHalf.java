package com.ss.leetcode.LC2021.january;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
    // https://leetcode.com/problems/reduce-array-size-to-the-half/
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count =  new HashMap<>();
        for (int num : arr) {
            count.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Integer> highestCount = new PriorityQueue<>(Comparator.reverseOrder());
        highestCount.addAll(count.values());
        int setSize = 0, minNums = 0;
        while(setSize < arr.length / 2) {
            setSize += highestCount.poll();
            minNums++;
        }
        return minNums;
    }

    public int minSetSize2(int[] arr) {
        int[] count = new int[100_001];
        for (int num : arr) {
            count[num]++;
        }
        Arrays.sort(count);
        int minSetSize = 0, eliminated = 0, half = arr.length / 2;

        for (int i = count.length -1; eliminated < half && i >= 1; i--) {
            eliminated += count[i];
            minSetSize++;
        }
        return minSetSize;
    }

    public int minSetSize3(int[] arr) {
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
