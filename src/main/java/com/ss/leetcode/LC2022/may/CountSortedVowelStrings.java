package com.ss.leetcode.LC2022.may;

import java.util.HashMap;
import java.util.Map;

public class CountSortedVowelStrings {
    // https://leetcode.com/problems/count-sorted-vowel-strings/
    /** Algorithm
         1. Take the example of n =1: [a,e,i,o,u] so strings .
             n = 2.
             For a we can have a + (all strings that can be formed with 1 char)
             For e we can have e (1) + all strings that can be formed with 1 char AFTER a
             For i we can have o(1) + all strings of 1 char that can be formed after e
         2. Take this into consideration and cache/map these based on side
             n = 1 -> [1,1,1,1,1]
             n = 2 -> a (can make 5 strings : with a,e,i,o,u)
             e can make 4 strings with e,i,o,u
             i can make 3 strings with i,o,u
             o - 2 strings
             u - 1 string
             [5,4,3,2,1]
             n = 3: letter a can make all 2 char strings, (5+4+3+2+1)
             letter e can make all 2 chars strings from e: 4+3+2+1
             i - all 2 chars strings from i : 3+2+1
             [15, 10, 6, 3, 1]
         3. Iteratively, build this from i = 1 to n. For speed reasons, cache these in static
             class map and build up from last value:
             eg: if first method call is n = 5, it will build to n = 5;
             if second call is n = 10, it will build from 6 to 10.
     */
    private static final Map<Integer, int[]> countMap = new HashMap<>();
    static {
        countMap.put(1, new int[]{1,1,1,1,1});
    }
    public int countVowelStrings(int n) {
        if (!countMap.containsKey(n)) {
            countAndPut(n);
        }
        int sum = 0;
        for (int partial : countMap.get(n)) {
            sum += partial;
        }
        return sum;
    }

    private void countAndPut(int n) {
        for (int i = 1; i <= n; i++) {
            if (!countMap.containsKey(i)) {
                countAndAddToMap(i);
            }
        }
    }

    private void countAndAddToMap(int size) {
        int[] count = new int[5];
        int[] prevCount = countMap.get(size -1);
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for(int j = i; j < 5; j++) {
                sum += prevCount[j];
            }
            count[i] = sum;
        }
        countMap.put(size, count);
    }
}
