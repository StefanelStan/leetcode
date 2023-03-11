package com.ss.leetcode.LC2023.march;

import java.util.HashMap;

public class SumOfBeautyOfAllSubstrings {
    // https://leetcode.com/problems/sum-of-beauty-of-all-substrings
    /** Algorithm
        1. Iterate with i from 0 to n -2 (inclusive). Inside the loop iterate with j from i+1 to n-1 (inclusive)
            n - length of string;
        2. Use an int[26] to mark/count each chars that are getting populated by the window expansion i -> j.
        3. For each j, iterate over this int[] count and detect min,max. Add their diff to the sum
        4. Each time you advance i, reset the count[] array.
        5. Return the sum;
     */
    public int beautySum(String s) {
        int beautySum = 0;
        char[] chrs = s.toCharArray();
        int min, max;
        for (int i = 0; i < chrs.length -1; i++) {
            int[] count = new int[26];
            count[chrs[i] - 'a']++;
            for (int j = i + 1; j < chrs.length; j++) {
                count[chrs[j] - 'a']++;
                beautySum += getSum(count);
            }
        }
        return beautySum;
    }

    private int getSum(int[] count) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int c : count) {
            max = Math.max(max, c);
            if (c > 0) {
                min = Math.min(c, min);
            }
        }
        return max - min;
    }
}
