package com.ss.leetcode.LC2021.august;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindLuckyIntegerInAnArray {
    // https://leetcode.com/problems/find-lucky-integer-in-an-array/
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> luckyMap = new TreeMap<>(Comparator.reverseOrder());
        for(int num : arr) {
            luckyMap.merge(num ,1,Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry : luckyMap.entrySet()) {
            if (entry.getValue() == entry.getKey()) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
