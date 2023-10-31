package com.ss.leetcode.LC2023.october;

public class FindTheOriginalArrayOfPrefixXor {
    // https://leetcode.com/problems/find-the-original-array-of-prefix-xor
    /** Algorithm
        1. The difference of XOR is XOR itself!
        2. Given a = b ^ c, then b = a^c and c = a^b.
        3. arr[0] = pref[0]
        4. With i from 1 to n-1
            - keep track of previousXor result (arr[0] ^ arr[i-1])
            - arr[i] is prevXor ^ pref[i]
            - adjust the previousXor with the newly calculated arr[i]. (prevXor = prevXor ^ arr[i])
     */
    public int[] findArray(int[] pref) {
        int[] found = new int[pref.length];
        int prevXor = found[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            found[i] = prevXor ^ pref[i];
            prevXor = prevXor ^ found[i];
        }
        return found;
    }
}
