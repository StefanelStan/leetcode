package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortIntegersByNumberOf1Bits {
    // https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
    public int[] sortByBits(int[] arr) {
        int[][] valueAndBitCount = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++) {
            valueAndBitCount[i][0] = arr[i];
            valueAndBitCount[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(valueAndBitCount, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] answer =  new int[arr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = valueAndBitCount[i][0];
        }
        return answer;
    }

    public int[] sortByBits2(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer, List<Integer>> bitBucket = new TreeMap<>();
        for (int num : arr) {
            List<Integer> bucket = bitBucket.computeIfAbsent(Integer.bitCount(num), k -> new ArrayList<>());
            bucket.add(num);
        }

        int[] index = {0};
        bitBucket.forEach((key, value) -> {
            Collections.sort(value);
            value.forEach(number -> {
                result[index[0]] = number;
                index[0]++;
            });
        });

        return result;
    }
}
