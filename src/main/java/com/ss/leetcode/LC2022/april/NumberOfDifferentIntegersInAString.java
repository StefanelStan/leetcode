package com.ss.leetcode.LC2022.april;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInAString {
    // https://leetcode.com/problems/number-of-different-integers-in-a-string/
    public int numDifferentIntegers(String word) {
        Set<String> ints = new HashSet<>();
        char[] chrs = word.toCharArray();
        int start = -1, stop = 0;
        for(int i = 0; i < chrs.length; i++) {
            if(chrs[i] >= '0' && chrs[i] <= '9') {
                if (start == -1) {
                    start = i;
                    stop = i;
                } else {
                    stop = i;
                }
            } else if (start != -1) {
                ints.add(extractInt(chrs, start, stop));
                start = -1;
            }
        }
        if (start != -1) {
            ints.add(extractInt(chrs, start, stop));
        }
        return ints.size();
    }

    private String extractInt(char[] chrs, int start, int stop) {
        StringBuilder stb = new StringBuilder();
        while(start <= stop && chrs[start] == '0') {
            start++;
        }
        if (start >= stop) {
            stb.append(chrs[stop]);
        } else {
            while(start <= stop) {
                stb.append(chrs[start++]);
            }
        }
        return stb.toString();
    }
}
