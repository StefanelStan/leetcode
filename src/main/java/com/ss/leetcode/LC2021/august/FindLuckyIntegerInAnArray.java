package com.ss.leetcode.LC2021.august;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindLuckyIntegerInAnArray {
    // https://leetcode.com/problems/find-lucky-integer-in-an-array/
    /** Algorithm
        1. Use an int[501] freq and traverse the nums to count the freq of each
        2. Loop from 500 to 1 and if current num matches freq[i], return i
        3. Else, return -1
     */
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public int findLucky2(int[] arr) {
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
