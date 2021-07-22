package com.ss.leetcode.july;

import java.util.Map;
import java.util.TreeMap;

public class MedianFinder {
    // https://leetcode.com/problems/find-median-from-data-stream/
    private final TreeMap<Integer, Integer> numbers;
    private int size = 0;
    public MedianFinder() {
        numbers = new TreeMap<>();
    }

    public void addNum(int num) {
        numbers.merge(num, 1, Integer::sum);
        size++;
    }

    public double findMedian() {
        boolean isOdd = size % 2 == 1;
        if (isOdd) {
            return getOddMedian(size / 2 + 1);
        } else {
            return getEvenMedian(size / 2 + 1);
        }
    }

    private double getOddMedian(int halfIndex) {
        int cumulativeSize = 0 ;
        for (Map.Entry<Integer, Integer> entry :  numbers.entrySet()) {
            cumulativeSize += entry.getValue();
            if (cumulativeSize >= halfIndex) {
                return (double)entry.getKey();
            }
        }
        return 0.0;
    }


    private double getEvenMedian(int rightIndex) {
        int cumulativeSize = 0;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (cumulativeSize + entry.getValue() >= rightIndex) {
                return (double)entry.getKey();
            } else {
                if (cumulativeSize + entry.getValue() >= rightIndex -1 && cumulativeSize + entry.getValue() < rightIndex) {
                    return (double)(entry.getKey() + numbers.higherKey(entry.getKey())) / 2;
                }
            }
            cumulativeSize += entry.getValue();
        }
        return 0.0;
    }
}
