package com.ss.leetcode.LC2023.december;

import java.util.Arrays;

public class DecodeWays {
    // https://leetcode.com/problems/decode-ways
    /** Algorithm
        1. Use a int[] decodings to cache the number of decodings can be done starting with index[0..n-1]
        2. Use a recursive function to calculate the possibilities for each index, starting from 0 to n-1
        3. If decodings[idx] exists, return it. Else calculate it
        4. If current char is 0, set 0 and return. You can's start with 0
        5. Determine the 1 digit value and call the function passing index +1
        6. If adding next digit renders a value < 26, add the result of func(index+2) to current decodings[index]
        7. Return decodings[index]
     */
    public int numDecodings(String s) {
        int[] decodings = new int[s.length()];
        Arrays.fill(decodings, -1);
        return findWays(0, s.toCharArray(), decodings);
    }

    private int findWays(int index, char[] chrs, int[] decodings) {
        if (index >= chrs.length) {
            return 1;
        }
        if (decodings[index] == -1) {
            decodings[index] = 0;
            int value = chrs[index] - '0';
            if (value > 0 && value < 27) {
                decodings[index] += findWays(index + 1, chrs, decodings);
                if (index < chrs.length - 1 && value * 10 + chrs[index+1] - '0' < 27) {
                    decodings[index] += findWays(index + 2, chrs, decodings);
                }
            }
        }
        return decodings[index];
    }
}
